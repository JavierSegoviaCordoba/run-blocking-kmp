plugins {
    jacoco
    java
}

jacoco {
    toolVersion = jacocoVersion
}

tasks.withType<JacocoReport> {
    dependsOn("check")

    val coverageSourceDirs = arrayOf(
        "src/commonMain",
        "src/jvmMain"
    )

    val classFiles =
        File("$buildDir/classes/kotlin/jvm/main")
            .walkBottomUp()
            .toSet()

    classDirectories.setFrom(classFiles)
    sourceDirectories.setFrom(files(coverageSourceDirs))
    additionalSourceDirs.setFrom(files(coverageSourceDirs))

    executionData.setFrom(files("$buildDir/jacoco/jvmTest.exec"))
    reports {
        xml.isEnabled = true
        html.isEnabled = true
    }
}

internal val Project.jacocoVersion: String
    get() = File("$rootDir/gradle/gradle-plugin-dependencies.toml")
        .readLines()
        .first { it.contains("jacoco") }
        .split("\"")[1]
