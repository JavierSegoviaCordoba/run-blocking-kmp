@file:Suppress("PropertyName", "VariableNaming")

// catalog start - pluginLibs

// [versions]
val javierscGradlePlugins = "0.1.0-alpha.46"
val kotlinBinaryValidator = "0.6.0"

// [libraries]
val javiersc_gradlePlugins_allProjects =
    "com.javiersc.gradle-plugins:all-projects:$javierscGradlePlugins"
val javiersc_gradlePlugins_buildVersionCatalogsUpdater =
    "com.javiersc.gradle-plugins:build-version-catalogs-updater:$javierscGradlePlugins"
val javiersc_gradlePlugins_changelog =
    "com.javiersc.gradle-plugins:changelog:$javierscGradlePlugins"
val javiersc_gradlePlugins_codeAnalysis =
    "com.javiersc.gradle-plugins:code-analysis:$javierscGradlePlugins"
val javiersc_gradlePlugins_codeFormatter =
    "com.javiersc.gradle-plugins:code-formatter:$javierscGradlePlugins"
val javiersc_gradlePlugins_dependencyUpdates =
    "com.javiersc.gradle-plugins:dependency-updates:$javierscGradlePlugins"
val javiersc_gradlePlugins_docs = "com.javiersc.gradle-plugins:docs:$javierscGradlePlugins"
val javiersc_gradlePlugins_gradleWrapperUpdater =
    "com.javiersc.gradle-plugins:gradle-wrapper-updater:$javierscGradlePlugins"
val javiersc_gradlePlugins_kotlinMultiplatform =
    "com.javiersc.gradle-plugins:kotlin-multiplatform:$javierscGradlePlugins"
val javiersc_gradlePlugins_nexus = "com.javiersc.gradle-plugins:nexus:$javierscGradlePlugins"
val javiersc_gradlePlugins_pluginAccessors =
    "com.javiersc.gradle-plugins:plugin-accessors:$javierscGradlePlugins"
val javiersc_gradlePlugins_publishKotlinMultiplatform =
    "com.javiersc.gradle-plugins:publish-kotlin-multiplatform:$javierscGradlePlugins"
val javiersc_gradlePlugins_readmeBadges =
    "com.javiersc.gradle-plugins:readme-badges:$javierscGradlePlugins"
val javiersc_gradlePlugins_versioning =
    "com.javiersc.gradle-plugins:versioning:$javierscGradlePlugins"
val jetbrains_kotlinx_binaryCompatibilityValidator =
    "org.jetbrains.kotlinx:binary-compatibility-validator:$kotlinBinaryValidator"

// [bundles]
val javierscPlugins = javiersc_gradlePlugins_allProjects + javiersc_gradlePlugins_changelog

// catalog end
