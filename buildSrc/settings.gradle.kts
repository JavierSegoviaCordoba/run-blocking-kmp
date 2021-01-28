dependencyResolutionManagement {
    versionCatalogs {
        create("gradlePluginLibs") { from(files("../gradle/gradle-plugin-dependencies.toml")) }
    }
}
