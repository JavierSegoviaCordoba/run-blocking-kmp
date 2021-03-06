import internal.groupId

plugins {
    kotlin("multiplatform")
    id("code-formatter")
    jacoco
}

group = groupId

kotlin {
    sourceSets {
        all { defaultLanguageSettings }
    }
}
