package com.javiersc.runBlocking

import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.runBlocking

/** JVM `runBlocking` implementation */
public actual fun <T> suspendTest(
    context: CoroutineContext,
    block: suspend CoroutineScope.() -> T
) {
    runBlocking(context, block)
}
