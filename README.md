![Kotlin version](https://img.shields.io/badge/kotlin-1.4.31-blueviolet)
[![MavenCentral](https://img.shields.io/maven-central/v/com.javiersc.run-blocking/run-blocking?label=MavenCentral)](https://repo1.maven.org/maven2/com/javiersc/run-blocking/run-blocking/)
[![Snapshot](https://img.shields.io/nexus/s/com.javiersc.run-blocking/run-blocking?server=https%3A%2F%2Foss.sonatype.org%2F&label=Snapshot)](https://oss.sonatype.org/content/repositories/snapshots/com/javiersc/run-blocking/run-blocking/)

[![Build](https://img.shields.io/github/workflow/status/JavierSegoviaCordoba/run-blocking-kmp/build?label=Build&logo=GitHub)](https://github.com/JavierSegoviaCordoba/run-blocking-kmp/tree/main)
[![Quality](https://img.shields.io/codacy/grade/6e5701cb8b2a48c3969fcb3edd27b4ce/main?label=Quality&logo=codacy&logoColor=white)](https://app.codacy.com/gh/JavierSegoviaCordoba/run-blocking-kmp/dashboard?branch=main)
[![Coverage](https://img.shields.io/codacy/coverage/6e5701cb8b2a48c3969fcb3edd27b4ce/main?label=Coverage&logo=codacy&logoColor=white)](https://app.codacy.com/gh/JavierSegoviaCordoba/run-blocking-kmp/dashboard?branch=main)

# RunBlocking KMP

```kotlin
fun main() = runBlocking {
    println(usersService.getUsers())
}
```

### Docs

All docs are available on the [RunBlocking KMP website](https://run-blocking-kmp.javiersc.com)

### Download from MavenCentral

```kotlin
implementation("com.javiersc.run-blocking:run-blocking:$version")
```
