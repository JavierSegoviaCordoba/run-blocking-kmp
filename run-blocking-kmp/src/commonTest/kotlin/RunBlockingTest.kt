package com.javiersc.runBlockingKMP

import io.kotest.matchers.booleans.shouldBeTrue
import kotlin.test.Test
import kotlinx.coroutines.delay

internal class RunBlockingTest {

    @Test fun testRunBlocking() = runBlocking { getBoolean().shouldBeTrue() }
}

internal suspend fun getBoolean(): Boolean = delay(0).run { true }
