import io.gitlab.arturbosch.detekt.Detekt

plugins {
    id("io.gitlab.arturbosch.detekt")
}

dependencies {
    detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:$detektVersion")
}

val detekt by tasks.named<Detekt>("detekt") {
    parallel = true
    ignoreFailures = true
    autoCorrect = true
    buildUponDefaultConfig = true
    setSource(files(projectDir))
    exclude("**/build/**")

    reports {
        html {
            enabled = true
            destination = file("$buildDir/reports/detekt/detekt.html")
        }
        txt { enabled = false }
        xml { enabled = false }
    }
}

internal val Project.detektVersion: String
    get() = File("$rootDir/gradle/gradle-plugin-dependencies.toml")
        .readLines()
        .first { it.contains("detekt") }
        .split("\"")[1]
