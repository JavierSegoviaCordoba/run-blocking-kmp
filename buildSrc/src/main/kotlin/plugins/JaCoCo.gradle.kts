plugins {
    jacoco
    java
}

jacoco {
    toolVersion = jacocoVersion
}

tasks.withType<JacocoReport> {
    dependsOn("check")

    val coverageSourceDirs =
        projectDir
            .walkTopDown()
            .asSequence()
            .filter { it.path.contains("Main") }
            .map { it.path.replaceBefore("src", "") }
            .map { it.replaceAfter("Main", "") }
            .toSet()

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
        xml.destination = file("$buildDir/reports/jacoco/report.xml")
        html.isEnabled = true
        html.destination = file("$buildDir/reports/jacoco/report.html")
        csv.isEnabled = false
    }
}

internal val Project.jacocoVersion: String
    get() = File("$rootDir/gradle/gradle-plugin-dependencies.toml")
        .readLines()
        .first { it.contains("jacoco") }
        .split("\"")[1]
