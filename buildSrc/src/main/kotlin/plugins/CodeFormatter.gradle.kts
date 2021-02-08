plugins {
    id("com.diffplug.spotless")
}

spotless {
    kotlin {
        target("src/**/*.kt")
        ktfmt(ktfmtVersion).dropboxStyle()
    }
}

internal val Project.ktfmtVersion: String
    get() = File("$rootDir/gradle/gradle-plugin-dependencies.toml")
        .readLines()
        .first { it.contains("ktfmt") }
        .split("\"")[1]
