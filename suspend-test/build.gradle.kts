plugins {
    `javiersc-kotlin-multiplatform`
    `javiersc-publish-kotlin-multiplatform`
}

kotlin {
    explicitApi()

    iosArm32()
    iosArm64()
    iosX64()

    jvm()

    js(BOTH) {
        browser()
        nodejs()
    }

    linuxX64()

    macosX64()

    mingwX64()

    tvos()

    // watchos()

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

        val iosArm32Main by getting
        val iosArm64Main by getting
        val iosX64Main by getting

        named("jvmMain")

        named("jsMain")

        val linuxX64Main by getting

        val macosX64Main by getting

        val mingwX64Main by getting

        val tvosMain by getting

        // val watchOsMain by getting

        create("nativeMain") {
            dependsOn(commonMain)
            iosArm32Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosX64Main.dependsOn(this)
            linuxX64Main.dependsOn(this)
            macosX64Main.dependsOn(this)
            mingwX64Main.dependsOn(this)
            tvosMain.dependsOn(this)
            // watchOsMain.dependsOn(this)
        }
    }
}
