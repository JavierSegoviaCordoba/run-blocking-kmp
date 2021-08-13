enableFeaturePreview("VERSION_CATALOGS")

dependencyResolutionManagement {
    repositories { mavenCentral() }

    versionCatalogs {
        create("libs") { from(files("../build/catalogs/libs.toml")) }
        create("pluginLibs") { from(files("../build/catalogs/pluginLibs.toml")) }
    }
}
