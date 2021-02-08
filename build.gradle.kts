plugins {
    Versioning
    Changelog
    CodeAnalysis
    DependencyUpdates
    Docs
    BinaryCompatibilityValidator
    Staging
}

tasks {
    withType<Test> {
        maxParallelForks = Runtime.getRuntime().availableProcessors()
        useJUnitPlatform()
        useTestNG()
    }
}
