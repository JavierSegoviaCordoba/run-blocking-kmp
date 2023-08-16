# Changelog

## [Unreleased]

### Added

### Changed

### Deprecated

### Removed

### Fixed

### Updated

- `com.javiersc.hubdle:com.javiersc.hubdle.gradle.plugin -> 0.5.0-beta.9`
- `gradle -> 8.2.1`

## [0.1.0-rc.1] - 2022-07-20

### Changed

- `com.javiersc.run-blocking:run-blocking-core` to `com.javiersc.kotlinx:coroutines-run-blocking`
- `com.javiersc.run-blocking:run-blocking-all` to `com.javiersc.kotlinx:coroutines-run-blocking-all`
- packages to `com.javiersc.kotlinx.coroutines.run.blocking`

### Removed

- `com.javiersc.run-blocking:suspend-test` artifact

### Updated

- `gradle -> 7.5`
- `org.jetbrains.kotlin:kotlin-gradle-plugin -> 1.7.10`

## [0.1.0-beta.3] - 2021-12-28

### Changed

- `suspend-test` returns `TestResult`
- `suspend-test` block only accepts `TestScope`
- `suspend-test` used `runTest` under the hood
- package to `com.javiersc.run.blocking`

### Updated

- `com.javiersc.gradle-plugins:all-plugins -> 0.1.0-rc.33`
- `org.jetbrains.kotlinx:kotlinx-coroutines-core -> 1.6.0`
- `gradle -> 7.3.3`
- `org.jetbrains.kotlin:kotlin-gradle-plugin -> 1.6.10`

## [0.1.0-beta.2] - 2021-11-29

### Added

- `run-blocking-all` which include JavaScript target

### Deprecated

- `suspend-test`

### Updated

- `com.javiersc.gradle-plugins:all-plugins -> 0.1.0-rc.19`
- `org.jetbrains.kotlinx:binary-compatibility-validator -> 0.8.0`
- `org.jetbrains.kotlinx:kotlinx-coroutines-core -> 1.5.2`
- `org.jetbrains.kotlin:kotlin-gradle-plugin -> 1.6.0`
- `gradle -> 7.3`

## [0.1.0-beta.1] - 2021-09-23

### Added

- Apple Silicon targets

## [0.1.0-alpha.4] - 2021-07-17

- No changes

## [0.1.0-alpha.3] - 2021-06-23

### Added

- `watchos` target support
- Improve targets

## [0.1.0-alpha.2] - 2021-05-03

- No changes

## [0.1.0-alpha.1] - 2021-03-07

### Added

- `runBlocking` function to `run-blocking`
- `suspendTest` function to `suspend-test`
