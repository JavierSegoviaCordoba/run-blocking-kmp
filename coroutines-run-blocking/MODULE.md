# Module run-blocking-core

`runBlocking` for all Kotlin Multiplatform targets except JavaScript

### Download from MavenCentral

```kotlin
implementation("com.javiersc.kotlinx:coroutines-run-blocking:$version")
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
