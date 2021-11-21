
rootProject.name = providers.gradleProperty("project.name").forUseAtConfigurationTime().get()

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
enableFeaturePreview("VERSION_CATALOGS")

dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }

    dependencyResolutionManagement {
        versionCatalogs {
            create("libs") { from(files("gradle/libs.toml")) }
            create("pluginLibs") { from(files("gradle/pluginLibs.toml")) }
        }
    }
}

include(
    ":run-blocking-core",
    ":suspend-test",
)
