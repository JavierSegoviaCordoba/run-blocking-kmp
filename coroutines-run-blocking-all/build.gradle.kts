hubdle {
    config {
        analysis()
        documentation {
            api()
        }
        explicitApi()
        publishing()
    }
    kotlin {
        multiplatform {
            features {
                coroutines()
            }

            common()
            apple {
                ios {
                    iosArm64()
                    iosSimulatorArm64()
                    iosX64()
                }
                macos {
                    macosArm64()
                    macosX64()
                }
                tvos {
                    tvosArm64()
                    tvosSimulatorArm64()
                    tvosX64()
                }
                watchos {
                    watchosArm64()
                    watchosSimulatorArm64()
                    watchosX64()
                }
            }
            jvm()
            js {
                browser()
                nodejs()
            }
            linux {
                linuxX64()
            }
            mingw {
                mingwX64()
            }

            native()
        }
    }
}
