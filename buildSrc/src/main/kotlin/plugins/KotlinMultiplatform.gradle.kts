plugins {
    kotlin("multiplatform")
    id("CodeFormatter")
}

kotlin {
    sourceSets {
        all { defaultLanguageSettings }
    }
}
