# Module run-blocking

`runBlocking` for all Kotlin Multiplatform targets except JavaScript

### Download from MavenCentral

```kotlin
implementation("com.javiersc.run-blocking:run-blocking-core:$version")
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
