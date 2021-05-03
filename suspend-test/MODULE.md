# Module suspend-test

`suspendTest` function for all Kotlin Multiplatform targets

### Download from MavenCentral

```kotlin
implementation("com.javiersc.run-blocking:suspend-test:$version")
```

### Usage

```kotlin
fun main() = suspendTest {
    println(usersService.getUsers())
}
```
