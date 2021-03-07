import internal.isSignificant

plugins {
    `maven-publish`
    signing
    id("docs")
}

val dokkaJar by tasks.creating(Jar::class) {
    archiveClassifier.set("javadoc")
    dependsOn(tasks.dokkaHtml)
}

publishing {
    publications.withType<MavenPublication> {
        pom {
            name.set(property("pomName").toString())
            description.set(property("pomDescription").toString())
            url.set(property("pomUrl").toString())

            licenses {
                license {
                    name.set(property("pomLicenseName").toString())
                    url.set(property("pomLicenseUrl").toString())
                }
            }

            developers {
                developer {
                    id.set(property("pomDeveloperId").toString())
                    name.set(property("pomDeveloperName").toString())
                    email.set(property("pomDeveloperEmail").toString())
                }
            }

            scm {
                url.set(property("pomSmcUrl").toString())
                connection.set(property("pomSmcConnection").toString())
                developerConnection.set(property("pomSmcDeveloperConnection").toString())
            }
        }

        artifact(dokkaJar)
    }
}

signing {
    if (!project.version.toString().endsWith("-SNAPSHOT") && isSignificant) {
        useGpgCmd()
        sign(publishing.publications)
    }
}

rootProject.tasks {
    getByName("initializeSonatypeStagingRepository") { dependsOn("checkIsSignificant") }
}

tasks {
    getByName("publish") { dependsOn("checkIsSignificant") }

    getByName("publishToSonatype") { dependsOn("checkIsSignificant") }

    getByName("publishToMavenLocal") { dependsOn("checkIsSignificant") }
}
