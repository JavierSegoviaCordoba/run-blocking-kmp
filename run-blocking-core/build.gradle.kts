plugins {
    `javiersc-kotlin-multiplatform`
    `javiersc-publish-kotlin-multiplatform`
}

kotlin {
    explicitApi()

    iosArm64()
    iosX64()

    jvm()

    linuxX64()

    macosX64()
    mingwX64()

    tvosArm64()
    tvosX64()

    watchosArm64()
    watchosX64()

    sourceSets {
        val commonMain by getting {
            dependencies { implementation(libs.jetbrains.kotlinx.kotlinxCoroutinesCore) }
        }

        commonTest {
            dependencies {
                implementation(libs.bundles.testing)
            }
        }

        val iosArm64Main by getting
        val iosX64Main by getting

        named("jvmMain")

        val linuxX64Main by getting

        val macosX64Main by getting

        val mingwX64Main by getting

        val tvosArm64Main by getting
        val tvosX64Main by getting

        val watchosArm64Main by getting
        val watchosX64Main by getting

        create("nativeMain") {
            dependsOn(commonMain)

            iosArm64Main.dependsOn(this)
            iosX64Main.dependsOn(this)

            linuxX64Main.dependsOn(this)

            macosX64Main.dependsOn(this)

            mingwX64Main.dependsOn(this)

            tvosArm64Main.dependsOn(this)
            tvosX64Main.dependsOn(this)

            watchosArm64Main.dependsOn(this)
            watchosX64Main.dependsOn(this)
        }
    }
}
