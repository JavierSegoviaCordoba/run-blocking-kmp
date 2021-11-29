![Kotlin version](https://img.shields.io/badge/kotlin-1.6.0-blueviolet?logo=kotlin&logoColor=white)
[![MavenCentral](https://img.shields.io/maven-central/v/com.javiersc.run-blocking/run-blocking-core?label=MavenCentral)](https://repo1.maven.org/maven2/com/javiersc/run-blocking/run-blocking-core/)
[![Snapshot](https://img.shields.io/nexus/s/com.javiersc.run-blocking/run-blocking-core?server=https%3A%2F%2Foss.sonatype.org%2F&label=Snapshot)](https://oss.sonatype.org/content/repositories/snapshots/com/javiersc/run-blocking/run-blocking-core/)

[![Build](https://img.shields.io/github/workflow/status/JavierSegoviaCordoba/run-blocking-kmp/build-kotlin?label=Build&logo=GitHub)](https://github.com/JavierSegoviaCordoba/run-blocking-kmp/tree/main)
[![Quality](https://img.shields.io/sonar/quality_gate/JavierSegoviaCordoba_run-blocking-kmp?label=Quality&logo=SonarCloud&logoColor=white&server=https%3A%2F%2Fsonarcloud.io)](https://sonarcloud.io/dashboard?id=JavierSegoviaCordoba_run-blocking-kmp)
[![Tech debt](https://img.shields.io/sonar/tech_debt/JavierSegoviaCordoba_run-blocking-kmp?label=Tech%20debt&logo=SonarCloud&logoColor=white&server=https%3A%2F%2Fsonarcloud.io)](https://sonarcloud.io/dashboard?id=JavierSegoviaCordoba_run-blocking-kmp)

# RunBlocking KMP

```kotlin
fun main() = runBlocking {
    println(usersService.getUsers())
}
```

## Docs

All docs are available on the [RunBlocking KMP website](https://run-blocking-kmp.javiersc.com)

## Download from MavenCentral

```kotlin
implementation("com.javiersc.run-blocking:run-blocking-core:$version")

// Including JavaScript
implementation("com.javiersc.run-blocking:run-blocking-all:$version")
```

## License

```
Copyright 2021 Javier Segovia Córdoba

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   https://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
