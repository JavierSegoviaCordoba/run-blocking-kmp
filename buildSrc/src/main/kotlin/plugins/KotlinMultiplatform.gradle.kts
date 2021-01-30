plugins {
    kotlin("multiplatform")
    id("code-analysis")
}

kotlin {
    sourceSets {
        all { defaultLanguageSettings }
    }
}
