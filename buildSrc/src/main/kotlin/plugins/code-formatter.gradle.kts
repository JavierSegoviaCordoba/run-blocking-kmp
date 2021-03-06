plugins {
    id("com.diffplug.spotless")
}

spotless {
    kotlin {
        target("src/**/*.kt")
        ktfmt(ktfmtVersion).kotlinlangStyle()
    }
}

internal val Project.ktfmtVersion: String
    get() = File("$rootDir/gradle/libs.versions.toml")
        .readLines()
        .first { it.contains("ktfmt") }
        .split("\"")[1]
