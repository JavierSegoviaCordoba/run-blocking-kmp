plugins {
    `javiersc-kotlin-multiplatform`
    `javiersc-publish-kotlin-multiplatform`
}

kotlin {
    explicitApi()

    ios()
    jvm()
    linuxX64()
    macosX64()
    mingwX64()
    tvos()
    watchos()

    sourceSets {
        val commonMain by getting {
            dependencies { implementation(libs.jetbrains.kotlinx.kotlinxCoroutinesCore) }
        }

        commonTest {
            dependencies {
                implementation(libs.jetbrains.kotlin.kotlinTest)
                implementation(libs.kotest.kotestAssertionsCore)
            }
        }

        val iosMain by getting

        named("jvmMain")
        val linuxX64Main by getting
        val macosX64Main by getting
        val mingwX64Main by getting
        val tvosMain by getting
        val watchosMain by getting

        create("nativeMain") {
            dependsOn(commonMain)
            iosMain.dependsOn(this)
            linuxX64Main.dependsOn(this)
            macosX64Main.dependsOn(this)
            mingwX64Main.dependsOn(this)
            tvosMain.dependsOn(this)
            watchosMain.dependsOn(this)
        }
    }
}
