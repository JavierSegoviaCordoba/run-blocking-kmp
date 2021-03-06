# Module run-blocking

`runBlocking` for all Kotlin Multiplatform targets except JavaScript

### Download from MavenCentral

```kotlin
implementation("com.javiersc.run-blocking:run-blocking:$version")
```

### Usage

```kotlin
class SomeTest {

    @Test 
    fun someTest() = suspendTest { 
        someSuspendFunction().shouldBeTrue()
    }
}
```

# Package com.javiersc.runBlockingKMP

Function `runBlocking`.

## Level 2 heading

`runBlocking` for all targets except `JS`.
