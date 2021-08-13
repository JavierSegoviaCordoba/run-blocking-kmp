@file:Suppress("PropertyName", "VariableNaming")

// catalog start - libs

// [versions]
val coroutines = "1.5.1-native-mt"
val kotest = "4.6.1"

// [libraries]
val jetbrains_kotlin_kotlinTest = "org.jetbrains.kotlin:kotlin-test"
val jetbrains_kotlinx_kotlinxCoroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutines"
val kotest_kotestAssertionsCore = "io.kotest:kotest-assertions-core:$kotest"

// [bundles]
val testing = jetbrains_kotlin_kotlinTest + kotest_kotestAssertionsCore

// catalog end
