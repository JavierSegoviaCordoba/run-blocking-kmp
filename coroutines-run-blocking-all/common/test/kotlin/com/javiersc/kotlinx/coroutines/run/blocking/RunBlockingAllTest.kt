package com.javiersc.kotlinx.coroutines.run.blocking

import kotlin.test.Test
import kotlin.test.assertTrue
import kotlinx.coroutines.yield

internal class RunBlockingAllTest {

    @Test fun runBlockingAllTest() = runBlocking { assertTrue { getBoolean() } }
}

internal suspend fun getBoolean(): Boolean = yield().run { true }
