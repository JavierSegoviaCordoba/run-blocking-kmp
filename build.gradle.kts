plugins {
    `javiersc-versioning`
    `javiersc-changelog`
    `javiersc-code-analysis`
    `javiersc-code-formatter`
    `javiersc-dependency-updates`
    `javiersc-docs`
    `kotlinx-binary-compatibility-validator`
    `javiersc-nexus`
    `javiersc-readme-badges-generator`
}

tasks {
    withType<Test> {
        maxParallelForks = Runtime.getRuntime().availableProcessors()
        useJUnitPlatform()
        useTestNG()
    }
}
