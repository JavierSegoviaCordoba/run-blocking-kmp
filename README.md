![Kotlin version](https://img.shields.io/badge/kotlin-1.5.0-blueviolet?logo=kotlin&logoColor=white)
[![MavenCentral](https://img.shields.io/maven-central/v/com.javiersc.run-blocking/run-blocking-core?label=MavenCentral)](https://repo1.maven.org/maven2/com/javiersc/run-blocking/run-blocking-core/)
[![Snapshot](https://img.shields.io/nexus/s/com.javiersc.run-blocking/run-blocking-core?server=https%3A%2F%2Foss.sonatype.org%2F&label=Snapshot)](https://oss.sonatype.org/content/repositories/snapshots/com/javiersc/run-blocking/run-blocking-core/)

[![Build](https://img.shields.io/github/workflow/status/JavierSegoviaCordoba/run-blocking-kmp/build?label=Build&logo=GitHub)](https://github.com/JavierSegoviaCordoba/run-blocking-kmp/tree/main)
[![Quality](https://img.shields.io/sonar/quality_gate/JavierSegoviaCordoba_run-blocking-kmp?label=Quality&logo=SonarCloud&logoColor=white&server=https%3A%2F%2Fsonarcloud.io)](https://sonarcloud.io/dashboard?id=JavierSegoviaCordoba_run-blocking-kmp)
[![Tech debt](https://img.shields.io/sonar/tech_debt/JavierSegoviaCordoba_run-blocking-kmp?label=Tech%20debt&logo=SonarCloud&logoColor=white&server=https%3A%2F%2Fsonarcloud.io)](https://sonarcloud.io/dashboard?id=JavierSegoviaCordoba_run-blocking-kmp)

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

// For testing
implementation("com.javiersc.run-blocking:suspend-test:$version")
```
