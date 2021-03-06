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
    /**
     * ToDo: workaround until accessors are available (https://github.com/gradle/gradle/issues/15383)
     *  When it is fixed, remove both implementations and remove `VersionCatalogExtension.kt` file
     */
    implementation(files(libs.javaClass.protectionDomain.codeSource.location))

    implementation(gradleApi())
    implementation(localGroovy())

    libs.plugin.apply {
        implementation(changelog)
        implementation(dependencyUpdates)
        implementation(detekt)
        implementation(dokka.core)
        implementation(dokka.plugin)
        implementation(kotlin.binaryCompabilityValidator)
        implementation(kotlin.plugin)
        implementation(kotlin.serialization)
        implementation(nexus.publish)
        implementation(reckon)
        implementation(spotless)
    }
}
