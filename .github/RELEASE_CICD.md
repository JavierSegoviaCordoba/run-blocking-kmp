# Release to MavenCentral from GitHub Actions

## Steps:

### Prerequisites

  1. Generate key: `gpg --full-generate-key`
  2. Check key id: `gpg --list-signatures`
  3. Upload to server: `gpg --keyserver hkps://keys.openpgp.org --send-keys [keyId]`
  4. Show the private key: `gpg --armor --export-secret-keys [keyId]`

> You can use GPG Suite and its GUI to do the previous steps

### Versioning

You can change the version in the next file:

- [gradle.properties](/gradle.properties)

#### Releases

Push to main

#### Snapshots

Push to develop

### Configure CI/CD (GitHub)

#### GitHub secrets

- KeyId as `gpgKeyName`
- Passphrase as `gpgPassphrase`
- Private key as `gpgKey`
    - Get the key using the command from point 4 in prerequisites.
- Sonatype - Nexus user as `ossUser`
- Sonatype - Nexus token as `ossToken`
- Sonatype - Nexus Profile ID as `ossStagingProfileId`
  - Visit this [link](https://oss.sonatype.org/#stagingProfiles), select your profile and copy
    `SOME_NUMBER` from the url `https://oss.sonatype.org/#stagingProfiles;SOME_NUMBERS`

#### GitHub workflow jobs

- Release

```yaml
name: Main

on:
  push:
    branches:
      - main

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

      - name: Import GPG key
        uses: crazy-max/ghaction-import-gpg@v3
        with:
          gpg-private-key: ${{ secrets.gpgKey }}
          passphrase: ${{ secrets.gpgPassphrase }}

      - name: Publish
        run: ./gradlew publishToSonatype -P"isLibRelease"="true" -P"signing.gnupg.keyName"="${{ secrets.gpgKeyName }}" -P"signing.gnupg.passphrase"="${{ secrets.gpgPassphrase }}"

      - name: Deploy docs to Github Pages
        if: ${{ matrix.os == 'ubuntu-latest' }}
        uses: JamesIves/github-pages-deploy-action@3.7.1
        with:
          GITHUB_TOKEN: ${{ secrets.GITHUB_TOKEN }}
          BRANCH: gh-pages
          FOLDER: build/dokka
          CLEAN: false
```

- Snapshot

```yaml
name: Develop

on:
  push:
    branches:
      - develop

env:
  ossUser: ${{ secrets.ossUser }}
  ossToken: ${{ secrets.ossToken }}
  ossStagingProfileId: ${{ secrets.ossStagingProfileId }}

jobs:
  build_and_release:
    strategy:
      matrix:
        os: [ macOS-latest, windows-latest, ubuntu-latest ]

    runs-on: ${{matrix.os}}

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

      - name: Publish
        run: ./gradlew publishToSonatype -P"isLibRelease"="false"

      - name: Deploy docs to Github Pages
        if: ${{ matrix.os == 'ubuntu-latest' }}
        uses: JamesIves/github-pages-deploy-action@3.7.1
        with:
          GITHUB_TOKEN: ${{ secrets.GITHUB_TOKEN }}
          TARGET_FOLDER: develop
          BRANCH: gh-pages
          FOLDER: build/dokka
          CLEAN: false

```
