
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
            File("${project.projectDir}/src/commonMain"),
            File("${project.projectDir}/src/jvmMain"),
            File("${project.projectDir}/src/androidMain"),
        )
    }

    val classes = subprojects.map { project ->
        File("${project.buildDir}/classes/kotlin/jvm/main")
    }

    additionalSourceDirs.setFrom(sources)
    sourceDirectories.setFrom(sources)
    classDirectories.setFrom(classes)
    executionData.setFrom(tasks.getByName<JacocoMerge>("jacocoMerge").destinationFile)

    reports {
        xml.isEnabled = true
        xml.destination = file("$buildDir/reports/jacoco/xml/jacoco.xml")
        html.isEnabled = true
        html.destination = file("$buildDir/reports/jacoco/html")
    }
}
