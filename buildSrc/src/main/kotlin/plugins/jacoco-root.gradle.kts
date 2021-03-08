
plugins {
    jacoco
}

jacoco {
    toolVersion = libs.versions.jacoco.get()
}

tasks.register<JacocoMerge>("jacocoMerge") {
    group = "verification"
    subprojects.onEach { subproject -> executionData(subproject.tasks.withType<Test>()) }
    doFirst { executionData = files(executionData.filter { it.exists() }) }
}

tasks.register<JacocoReport>("jacocoTestReport") {
    group = "verification"

    dependsOn(subprojects.map { it.tasks.getByName("check") })
    dependsOn("jacocoMerge")

    val sources = subprojects.flatMap { project ->
        listOf(
            file("${project.projectDir}/src/commonMain/kotlin"),
            file("${project.projectDir}/src/jvmMain/kotlin"),
            file("${project.projectDir}/src/androidMain/kotlin"),
        )
    }

    val classes = subprojects.map { project ->
        file("${project.buildDir}/classes/kotlin/jvm/main")
    }

    classDirectories.setFrom(classes)
    sourceDirectories.setFrom(files(sources))

    executionData.setFrom(tasks.getByName<JacocoMerge>("jacocoMerge").destinationFile)

    reports {
        xml.isEnabled = true
        xml.destination = file("$buildDir/reports/jacoco/xml/jacoco.xml")
        html.isEnabled = true
        html.destination = file("$buildDir/reports/jacoco/html")
    }
}
