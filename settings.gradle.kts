plugins {
    `gradle-enterprise`
}

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

gradleEnterprise {
    buildScan {
        termsOfServiceUrl = "https://gradle.com/terms-of-service"
        termsOfServiceAgree = "yes"
    }
}

include(
    ":run-blocking-all",
    ":run-blocking-core",
    ":suspend-test",
)
