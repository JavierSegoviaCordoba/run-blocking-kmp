plugins {
    Versioning
    Changelog
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
