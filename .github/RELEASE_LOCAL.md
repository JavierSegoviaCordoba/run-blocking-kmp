# Release to MavenCentral from local machine

## Steps:

### Prerequisites

  1. Generate key: `gpg --full-generate-key`
  2. Check key id: `gpg --list-signatures`
  3. Upload to server: `gpg --keyserver hkps://keys.openpgp.org --send-keys [keyId]`
  4. Add Nexus user environment variable: `ossUser`
  5. Add Nexus token environment variable: `ossToken`

> You can use GPG Suite and its GUI to do the previous steps

### Versioning

You can change the version and indicate if is release or snapshot in the next file:

- [gradle.properties](/gradle.properties)

#### Releases

Change the project version and set `isLibRelease` to true.

#### Snapshots

Change the project version and set `isLibRelease` to false.

Automatically, the version generated includes a timestamp and the suffix `-SNAPSHOT`.

### Upload artifacts to Nexus Repository Manager

Launch the next command:

```
./gradlew publishToSonatype -Psigning.gnupg.keyName=[keyId] -Psigning.gnupg.passphrase=[passphrase]
```

You can overwrite `isLibRelease` via command line adding `-PisLibRelease=value`:

```
./gradlew publishToSonatype -PisLibRelease=true -Psigning.gnupg.keyName=[keyId] -Psigning.gnupg.passphrase=[passphrase]
```
