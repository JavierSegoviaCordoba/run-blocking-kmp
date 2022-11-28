# detekt

## Metrics

* 1 number of properties

* 11 number of functions

* 2 number of classes

* 2 number of packages

* 13 number of kt files

## Complexity Report

* 290 lines of code (loc)

* 177 source lines of code (sloc)

* 118 logical lines of code (lloc)

* 53 comment lines of code (cloc)

* 13 cyclomatic complexity (mcc)

* 4 cognitive complexity

* 1 number of total code smells

* 29% comment source ratio

* 110 mcc per 1,000 lloc

* 8 code smells per 1,000 lloc

## Findings (1)

### naming, MemberNameEqualsClassName (1)

A member should not be given the same name as its parent class or object.

[Documentation](https://detekt.dev/docs/rules/naming#membernameequalsclassname)

* coroutines-run-blocking-all/common/test/kotlin/com/javiersc/kotlinx/coroutines/run/blocking/RunBlockingAllTest.kt:9:5
```
A member is named after the class. This might result in confusion. Either rename the member or change it to a constructor.
```
```kotlin
6  
7  internal class RunBlockingAllTest {
8  
9      @Test fun runBlockingAllTest() = runBlocking { assertTrue { getBoolean() } }
!      ^ error
10 }
11 
12 internal suspend fun getBoolean(): Boolean = yield().run { true }

```

generated with [detekt version 1.22.0](https://detekt.dev/) on 2022-11-28 10:48:25 UTC
