
rootProject.name = providers.gradleProperty("allProjects.name").forUseAtConfigurationTime().get()

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
enableFeaturePreview("VERSION_CATALOGS")

pluginManagement {
    repositories {
        mavenCentral()
    }

    plugins {
        val buildVersionCatalogs: String by settings

        id("com.javiersc.gradle.plugins.build.version.catalogs") version buildVersionCatalogs
    }
}

plugins {
    id("com.javiersc.gradle.plugins.build.version.catalogs")
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
}

include(
    ":a--catalogs:libs",
    ":a--catalogs:plugins",
)

include(
    ":run-blocking-core",
    ":suspend-test",
)
