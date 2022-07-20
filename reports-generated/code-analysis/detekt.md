# detekt

## Metrics

* 1 number of properties

* 14 number of functions

* 3 number of classes

* 2 number of packages

* 16 number of kt files

## Complexity Report

* 383 lines of code (loc)

* 249 source lines of code (sloc)

* 166 logical lines of code (lloc)

* 53 comment lines of code (cloc)

* 17 cyclomatic complexity (mcc)

* 4 cognitive complexity

* 1 number of total code smells

* 21% comment source ratio

* 102 mcc per 1,000 lloc

* 6 code smells per 1,000 lloc

## Findings (1)

### naming, MemberNameEqualsClassName (1)

A member should not be given the same name as its parent class or object.

[Documentation](https://detekt.dev/docs/rules/naming#membernameequalsclassname)

* run-blocking-all/common/test/kotlin/com/javiersc/run/blocking/RunBlockingAllTest.kt:9:5
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

generated with [detekt version 1.21.0](https://detekt.dev/) on 2022-07-20 20:41:39 UTC
