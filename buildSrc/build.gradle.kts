plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    google()
    gradlePluginPortal()
}

dependencies {
    implementation(gradleApi())
    implementation(localGroovy())

    pluginLibs.apply {
        implementation(javiersc.gradlePlugins.allProjects)
        implementation(javiersc.gradlePlugins.changelog)
        implementation(javiersc.gradlePlugins.codeAnalysis)
        implementation(javiersc.gradlePlugins.codeFormatter)
        implementation(javiersc.gradlePlugins.dependencyUpdates)
        implementation(javiersc.gradlePlugins.docs)
        implementation(javiersc.gradlePlugins.gradleWrapperUpdater)
        implementation(javiersc.gradlePlugins.kotlinMultiplatform)
        implementation(javiersc.gradlePlugins.massiveCatalogsUpdater)
        implementation(javiersc.gradlePlugins.nexus)
        implementation(javiersc.gradlePlugins.pluginAccessors)
        implementation(javiersc.gradlePlugins.publishKotlinMultiplatform)
        implementation(javiersc.gradlePlugins.readmeBadges)
        implementation(javiersc.gradlePlugins.versioning)
        implementation(jetbrains.kotlinx.binaryCompatibilityValidator)
    }
}
