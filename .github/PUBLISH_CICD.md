# Publish

## Prerequisites

  1. Generate key: `gpg --full-generate-key`
  2. Check key id: `gpg --list-signatures`
  3. Upload to server: `gpg --keyserver hkps://keys.openpgp.org --send-keys [keyId]`
  4. Show the private key: `gpg --armor --export-secret-keys [keyId]`

> You can use GUI utilities:
> - Kleopatra for Windows
> - GPG Suite (GPGTools) for macOS

## Versioning

You can change the version in the next file:

- [gradle.properties](/gradle.properties)

## Configure CI/CD (GitHub)

### GitHub secrets

- KeyId as `gpgKeyName`
- Passphrase as `gpgPassphrase`
- Private key as `gpgKey`
    - Get the key using the command from point 4 in prerequisites.
- Sonatype - Nexus user as `ossUser`
- Sonatype - Nexus token as `ossToken`
- Sonatype - Nexus Profile ID as `ossStagingProfileId`
  - Visit this [link](https://oss.sonatype.org/#stagingProfiles), select your profile and copy
    `SOME_NUMBER` from the url `https://oss.sonatype.org/#stagingProfiles;SOME_NUMBERS`

### GitHub workflow jobs

#### Dispatch

```yaml
name: publish-dispatcher

on: [ workflow_dispatch ]

env:
  ossUser: ${{ secrets.ossUser }}
  ossToken: ${{ secrets.ossToken }}
  gpgKeyName: ${{ secrets.gpgKeyName }}
  gpgPassphrase: ${{ secrets.gpgPassphrase }}
  ossStagingProfileId: ${{ secrets.ossStagingProfileId }}

jobs:
  build_and_release:
    strategy:
      matrix:
        os: [ macOS-latest, windows-latest, ubuntu-latest ]

    runs-on: ${{matrix.os}}

    if: github.ref == 'refs/heads/main' || github.ref == 'refs/heads/develop'

    steps:
      - name: Checkout
        uses: actions/checkout@v2

      - name: Set up Java
        uses: actions/setup-java@v1
        with:
          java-version: 15

      - name: Gradle cache
        uses: actions/cache@v2
        with:
          path: |
            ~/.gradle/caches
            ~/.gradle/wrapper
            ~/.konan
          key: ${{ runner.os }}-gradle-${{ hashFiles('**/*.gradle*') }}
          restore-keys: |
            ${{ runner.os }}-gradle-

      - name: Gradle build
        run: ./gradlew build

      - name: Generate docs
        if: matrix.os == 'ubuntu-latest'
        run: ./gradlew dokkaHtmlMultiModule

      - name: Import GPG key
        if: github.ref == 'refs/heads/main'
        uses: crazy-max/ghaction-import-gpg@v3
        with:
          gpg-private-key: ${{ secrets.gpgKey }}
          passphrase: ${{ secrets.gpgPassphrase }}

      - name: Publish a release
        if: github.ref == 'refs/heads/main'
        run: ./gradlew publishToSonatype -P"signing.gnupg.keyName"="${{ secrets.gpgKeyName }}" -P"signing.gnupg.passphrase"="${{ secrets.gpgPassphrase }}"

      - name: Publish a snapshot
        if: github.ref == 'refs/heads/develop'
        run: ./gradlew publishToSonatype

      - name: Deploy release docs to Github Pages
        if: matrix.os == 'ubuntu-latest' && github.ref == 'refs/heads/main'
        uses: JamesIves/github-pages-deploy-action@3.7.1
        with:
          GITHUB_TOKEN: ${{ secrets.GITHUB_TOKEN }}
          BRANCH: gh-pages
          FOLDER: build/dokka
          CLEAN: false
          SINGLE_COMMIT: true

      - name: Deploy snapshot docs to Github Pages
        if: matrix.os == 'ubuntu-latest' && github.ref == 'refs/heads/develop'
        uses: JamesIves/github-pages-deploy-action@3.7.1
        with:
          GITHUB_TOKEN: ${{ secrets.GITHUB_TOKEN }}
          TARGET_FOLDER: snapshot
          BRANCH: gh-pages
          FOLDER: build/dokka
          CLEAN: false
          SINGLE_COMMIT: true
```
