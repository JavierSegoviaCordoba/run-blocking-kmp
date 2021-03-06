package com.javiersc.runBlocking

import io.kotest.matchers.booleans.shouldBeTrue
import kotlin.test.Test
import kotlinx.coroutines.yield

internal class SuspendTestTest {

    @Test fun testSuspendTest() = suspendTest { getBoolean().shouldBeTrue() }
}

internal suspend fun getBoolean(): Boolean = yield().run { true }
