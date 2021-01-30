plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    jcenter()
    google()
    gradlePluginPortal()
}

dependencies {
    implementation(gradleApi())
    implementation(localGroovy())

    gradlePluginLibs.apply {
        implementation(changelog)
        implementation(dependencyUpdates)
        implementation(detekt)
        implementation(dokka.core)
        implementation(dokka.plugin)
        implementation(kotlin.plugin)
        implementation(kotlin.binaryCompabilityValidator)
        implementation(kotlin.serialization)
        implementation(nexus.staging)
        implementation(nexus.publish)
    }
}
