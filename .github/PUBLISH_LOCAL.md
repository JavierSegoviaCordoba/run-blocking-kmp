# Publish from local machine

## Prerequisites

1. Generate key: `gpg --full-generate-key`
2. Check key id: `gpg --list-signatures`
3. Upload to server: `gpg --keyserver hkps://keys.openpgp.org --send-keys [keyId]`
4. Add Nexus user environment variable: `ossUser`
5. Add Nexus token environment variable: `ossToken`

> You can use GUI utilities:
> - Kleopatra for Windows
> - GPG Suite (GPGTools) for macOS

## Versioning

You can change the version and indicate if is release or snapshot
in [gradle.properties](/gradle.properties) file

## Releases

Change the project version if necessary and set `isLibRelease` to true.

## Snapshots

Change the project version if necessary and set `isLibRelease` to false.

Automatically, the version generated includes a timestamp and the suffix `-SNAPSHOT`.

## Upload artifacts to Nexus Repository Manager

### Snapshot

```
./gradlew publishToSonatype -P"isLibRelease"="false"
```

If `isLibRelease` is set to false in [gradle.properties](/gradle.properties) you can
remove `-P"isLibRelease"="false"`

### Release

```
./gradlew publishToSonatype -P"isLibRelease"="true" -Psigning.gnupg.keyName=[keyId] -Psigning.gnupg.passphrase=[passphrase]
```

If `isLibRelease` is set to true in [gradle.properties](/gradle.properties) you can
remove `-P"isLibRelease"="true"`
