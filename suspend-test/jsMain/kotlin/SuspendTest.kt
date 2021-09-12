package com.javiersc.runBlocking

import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

/** JS `runBlocking` implementation */
public actual fun <T> suspendTest(
    context: CoroutineContext,
    block: suspend CoroutineScope.() -> T
) {
    GlobalScope.promise(context) { block() }
}
