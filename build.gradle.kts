plugins {
    versioning
    changelog
    `code-analysis`
    `dependency-updates`
    docs
    `binary-compatibility-validator`
    `jacoco-root`
    nexus
}

tasks {
    withType<Test> {
        maxParallelForks = Runtime.getRuntime().availableProcessors()
        useJUnitPlatform()
        useTestNG()
    }
}
