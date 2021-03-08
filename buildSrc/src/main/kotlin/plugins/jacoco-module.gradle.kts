import gradle.kotlin.dsl.accessors._0fe7296b6d4bfdb50cb45e93dbb964d2.jacoco
import org.gradle.kotlin.dsl.jacoco
import org.gradle.kotlin.dsl.register
import org.gradle.testing.jacoco.tasks.JacocoReport

plugins {
    jacoco
}

jacoco {
    toolVersion = libs.versions.jacoco.get()
}

tasks.register<JacocoReport>("jacocoTestReport") {
    group = "verification"

    dependsOn("check")

    val sources =
        listOf(
            file("src/commonMain/kotlin"),
            file("src/jvmMain/kotlin"),
            file("src/androidMain/kotlin"),
        )

    val classes = file("${project.buildDir}/classes/kotlin/jvm/main")

    classDirectories.setFrom(classes)
    sourceDirectories.setFrom(files(sources))

    executionData.setFrom(files("$buildDir/jacoco/jvmTest.exec"))

    reports {
        xml.isEnabled = true
        xml.destination = file("$buildDir/reports/jacoco/xml/jacoco.xml")
        html.isEnabled = true
        html.destination = file("$buildDir/reports/jacoco/html")
    }
}
