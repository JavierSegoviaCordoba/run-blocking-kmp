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

// TODO

## Upload artifacts to Nexus Repository Manager

### Snapshot

Version should end with `-SNAPSHOT`

```
./gradlew publishToSonatype
```

### Release

```
./gradlew publishToSonatype -Psigning.gnupg.keyName=[keyId] -Psigning.gnupg.passphrase=[passphrase]
```
