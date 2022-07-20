package com.javiersc.run.blocking

import kotlin.test.Test
import kotlin.test.assertTrue
import kotlinx.coroutines.yield

internal class RunBlockingTest {

    @Test fun testRunBlocking() = runBlocking { assertTrue { getBoolean() } }
}

internal suspend fun getBoolean(): Boolean = yield().run { true }
