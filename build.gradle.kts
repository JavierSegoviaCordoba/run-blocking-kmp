import tasks.baseKotlinOptions

plugins {
    Versioning
    Changelog
    DependencyUpdates
    Detekt
    Dokka
    KotlinBinaryCompatibilityValidator
    NexusStaging
}

allprojects {
    tasks {
        withType<Delete> { delete(buildDir) }
        baseKotlinOptions
    }
}

tasks {
    withType<Test> {
        maxParallelForks = Runtime.getRuntime().availableProcessors()
        useJUnitPlatform()
        useTestNG()
    }
}
