package com.javiersc.run.blocking

import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlinx.coroutines.test.TestResult
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.runTest

@Deprecated(
    message = "kotlinx-coroutines-test:1.6.0+ has added support to Kotlin Multiplatform",
    replaceWith = ReplaceWith("runTest", "kotlinx.coroutines.test.runTest"),
)
public fun suspendTest(
    context: CoroutineContext = EmptyCoroutineContext,
    block: suspend TestScope.() -> Unit
): TestResult = runTest(context = context, testBody = block)
