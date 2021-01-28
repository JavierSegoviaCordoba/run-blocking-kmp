
rootProject.name = "run-blocking-kmp"

enableFeaturePreview("GRADLE_METADATA")
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

dependencyResolutionManagement {
    repositories {
        mavenLocal()
        mavenCentral()
        jcenter()
    }
}

include(":run-blocking-kmp")
