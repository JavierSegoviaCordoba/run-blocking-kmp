package com.javiersc.runBlocking

import io.kotest.matchers.booleans.shouldBeTrue
import kotlin.test.Test
import kotlinx.coroutines.yield

internal class RunBlockingTest {

    @Test fun testRunBlocking() = runBlocking { getBoolean().shouldBeTrue() }
}

internal suspend fun getBoolean(): Boolean = yield().run { true }
