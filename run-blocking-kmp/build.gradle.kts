plugins {
    KotlinMultiplatform
    Publish
}

kotlin {
    explicitApi()

    iosArm32()
    iosArm64()
    iosX64()

    jvm()

    linuxX64()

    macosX64()

    mingwX64()

    tvosArm64()
    tvosX64()

    watchosArm32()
    watchosArm64()
    watchosX86()

    sourceSets {
        val commonMain by getting {
            dependencies {
                libs.common.main.apply {
                    implementation(coroutines.core)
                }
            }
        }

        commonTest {
            dependencies {
                libs.common.test.apply {
                    implementation(kotest.assertions)
                    implementation(kotlin.test.annotations)
                    implementation(kotlin.test.common)
                    implementation(kotlin.test.junit)
                }
            }
        }

        val iosArm32Main by getting
        val iosArm64Main by getting
        val iosX64Main by getting

        named("jvmMain")

        val linuxX64Main by getting

        val macosX64Main by getting

        val mingwX64Main by getting

        val tvosArm64Main by getting
        val tvosX64Main by getting

        val watchosArm32Main by getting
        val watchosArm64Main by getting
        val watchosX86Main by getting

        create("nativeMain") {
            dependsOn(commonMain)

            listOf(
                iosArm32Main,
                iosArm64Main,
                iosX64Main,
                linuxX64Main,
                macosX64Main,
                mingwX64Main,
                tvosArm64Main,
                tvosX64Main,
                watchosArm32Main,
                watchosArm64Main,
                watchosX86Main,
            ).onEach { sourceSet ->
                sourceSet.dependsOn(this)
            }
        }

        defaultLanguageSettings
    }
}
