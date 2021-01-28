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
        implementation(dependencyUpdates)
        implementation(detekt)
        implementation(dokka.core)
        implementation(dokka.plugin)
        implementation(kotlin.plugin)
        implementation(kotlin.serialization)
        implementation(jacoco)
        implementation(nexus.staging)
        implementation(nexus.publish)
    }
}
