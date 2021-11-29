# Module run-blocking-all

`runBlocking` function for all Kotlin Multiplatform targets

### Download from MavenCentral

```kotlin
implementation("com.javiersc.run-blocking:run-blocking-all:$version")
```

### Usage

```kotlin
fun main() = runBlocking {
    println(usersService.getUsers())
}
```
