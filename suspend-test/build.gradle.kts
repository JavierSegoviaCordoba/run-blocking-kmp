plugins {
    alias(libs.plugins.javiersc.hubdle)
}

hubdle {
    config {
        explicitApi()
        languageSettings {
            experimentalCoroutinesApi()
        }
        publishing()
    }
    kotlin {
        multiplatform {
            features {
                coroutines()
            }

            common {
                main {
                    dependencies {
                        implementation(jetbrainsKotlinxCoroutinesTest())
                    }
                }
            }

            iosArm64()
            iosSimulatorArm64()
            iosX64()

            jvm()

            js {
                browser()
                nodejs()
            }

            linuxX64()

            native()

            macosArm64()
            macosX64()

            mingwX64()

            tvosArm64()
            tvosSimulatorArm64()
            tvosX64()

            watchosArm64()
            watchosSimulatorArm64()
            watchosX64()
        }
    }
}
