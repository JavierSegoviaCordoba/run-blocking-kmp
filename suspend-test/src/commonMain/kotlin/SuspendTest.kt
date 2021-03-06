package com.javiersc.runBlocking

import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope

/**
 * Runs a new coroutine and **blocks** the current thread _interruptibly_ until its completion. This
 * function should not be used from a coroutine. It is designed to bridge regular blocking code to
 * libraries that are written in suspending style, to be used in `main` functions and in tests.
 *
 * The default [CoroutineDispatcher] for this builder is an internal implementation of event loop
 * that processes continuations in this blocked thread until the completion of this coroutine. See
 * [CoroutineDispatcher] for the other implementations that are provided by `kotlinx.coroutines`.
 *
 * When [CoroutineDispatcher] is explicitly specified in the [context], then the new coroutine runs
 * in the context of the specified dispatcher while the current thread is blocked. If the specified
 * dispatcher is an event loop of another `runBlocking`, then this invocation uses the outer event
 * loop.
 *
 * If this blocked thread is interrupted (see [Thread.interrupt]), then the coroutine job is
 * cancelled and this `runBlocking` invocation throws [InterruptedException].
 *
 * See [newCoroutineContext] [CoroutineScope.newCoroutineContext] for a description of debugging
 * facilities that are available for a newly created coroutine.
 *
 * @param context the context of the coroutine. The default value is an event loop on the current
 * thread.
 * @param block the coroutine code.
 */
public expect fun <T> suspendTest(
    context: CoroutineContext = EmptyCoroutineContext,
    block: suspend CoroutineScope.() -> T
)
