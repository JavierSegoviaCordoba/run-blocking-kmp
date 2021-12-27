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

    // TODO: remove when the next issue is fixed:
    //  https://github.com/gradle/gradle/issues/15383#issuecomment-779893192
    implementation(files(pluginLibs.javaClass.superclass.protectionDomain.codeSource.location))

    implementation(pluginLibs.javiersc.gradlePlugins.allPlugins)
    implementation(pluginLibs.jetbrains.kotlin.kotlinGradlePlugin)
    implementation(pluginLibs.jetbrains.kotlinx.binaryCompatibilityValidator)
}
