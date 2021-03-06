| [![Release Download](https://img.shields.io/maven-central/v/com.javiersc.run-blocking-kmp/run-blocking-kmp?label=Release)](https://repo1.maven.org/maven2/com/javiersc/run-blocking-kmp/run-blocking-kmp/)                                                                           | [![Main Checks](https://img.shields.io/github/checks-status/JavierSegoviaCordoba/run-blocking-kmp/main?label=main&logo=GitHub)](https://github.com/JavierSegoviaCordoba/run-blocking-kmp/tree/main)             | [![Quality Main](https://img.shields.io/codacy/grade/6e5701cb8b2a48c3969fcb3edd27b4ce/main?label=main&logo=codacy&logoColor=white)](https://app.codacy.com/gh/JavierSegoviaCordoba/run-blocking-kmp/dashboard?branch=main)             |
| :----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | :-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | :--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [![Snapshot Download](https://img.shields.io/nexus/s/com.javiersc.run-blocking-kmp/run-blocking-kmp?server=https%3A%2F%2Foss.sonatype.org%2F&label=Snapshot&color=orange)](https://oss.sonatype.org/content/repositories/snapshots/com/javiersc/run-blocking-kmp/run-blocking-kmp/)  | [![Develop Checks](https://img.shields.io/github/checks-status/JavierSegoviaCordoba/run-blocking-kmp/develop?label=develop&logo=GitHub)](https://github.com/JavierSegoviaCordoba/run-blocking-kmp/tree/develop) | [![Quality Develop](https://img.shields.io/codacy/grade/6e5701cb8b2a48c3969fcb3edd27b4ce/develop?label=develop&logo=codacy&logoColor=white)](https://app.codacy.com/gh/JavierSegoviaCordoba/run-blocking-kmp/dashboard?branch=develop) |

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
implementation("com.javiersc.run-blocking:run-blocking-core:$version")
```
