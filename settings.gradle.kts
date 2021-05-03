
rootProject.name = providers.gradleProperty("libName").forUseAtConfigurationTime().get()

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
enableFeaturePreview("VERSION_CATALOGS")

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        jcenter()
    }

    versionCatalogs {
        val massiveCatalogs: String by settings

        create("libs") { from("com.javiersc.massive-catalogs:libs-catalog:$massiveCatalogs") }
    }
}

include(":run-blocking-core")
include(":suspend-test")
