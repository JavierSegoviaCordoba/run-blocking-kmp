package com.javiersc.run.blocking

import kotlin.test.Test
import kotlin.test.assertTrue
import kotlinx.coroutines.yield

internal class SuspendTestTest {

    @Test fun testSuspendTest() = suspendTest { assertTrue { getBoolean() } }
}

internal suspend fun getBoolean(): Boolean = yield().run { true }
