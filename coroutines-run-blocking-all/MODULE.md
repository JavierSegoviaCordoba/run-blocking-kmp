# Module run-blocking-all

`runBlocking` function for all Kotlin Multiplatform targets

### Download from MavenCentral

```kotlin
implementation("com.javiersc.kotlinx:coroutines-run-blocking-all:$version")
```

### Usage

```kotlin
fun main() = runBlocking {
    println(usersService.getUsers())
}
```
