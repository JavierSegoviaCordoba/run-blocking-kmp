import java.io.FileInputStream
import java.util.Properties

enableFeaturePreview("VERSION_CATALOGS")

val input = FileInputStream(file("../gradle.properties"))
val properties = Properties().apply { load(input) }

input.close()

val massiveCatalogs: String = properties.getProperty("massiveCatalogs")

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        maven {
            setUrl("https://oss.sonatype.org/content/repositories/snapshots")
            content {
                includeGroup("com.javiersc.massive-catalogs")
                includeGroup("com.javiersc.gradle-plugins")
            }
        }
    }

    versionCatalogs {
        create("libs") { from("com.javiersc.massive-catalogs:libs-catalog:$massiveCatalogs") }
        create("pluginLibs") {
            from("com.javiersc.massive-catalogs:plugins-catalog:$massiveCatalogs")
        }
    }
}
