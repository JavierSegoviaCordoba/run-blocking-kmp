
rootProject.name = providers.gradleProperty("libName").forUseAtConfigurationTime().get()

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        jcenter()
    }
}

pluginManagement {
    val autoIncludeVersion =
        File("$rootDir/gradle/libs.versions.toml")
            .readLines()
            .first { it.contains("autoInclude") }
            .split("\"")[1]

    plugins {
        id("com.pablisco.gradle.auto.include") version autoIncludeVersion
    }
}

plugins {
    id("com.pablisco.gradle.auto.include")
}
