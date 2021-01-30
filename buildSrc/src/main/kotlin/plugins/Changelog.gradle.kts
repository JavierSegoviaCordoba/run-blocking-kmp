import org.jetbrains.changelog.closure
import org.jetbrains.changelog.date

// Workaround to fix: https://github.com/JetBrains/gradle-changelog-plugin/issues/26
// When it is fixed, remove `projectVersion` variable and `project.version = ...` assignments
val projectVersion = project.version

project.version = "$projectVersion"

plugins {
    id("org.jetbrains.changelog")
}

project.version = projectVersion

changelog {
    version = "${project.version}"
    header = closure { "[$version] - ${date()}" }
    groups = listOf("Added", "Changed", "Deprecated", "Removed", "Fixed", "Updated")
}

tasks {
    patchChangelog {
        doFirst { project.version = "$projectVersion" }
        doLast {
            improveChangelog(File("$projectDir/CHANGELOG.md"), "Unreleased")
            project.version = projectVersion
        }
    }
}

fun improveChangelog(changelogFile: File, unreleasedFlag: String) {
    val filteredChangelog = changelogFile
        .readLines()
        .filter { it.isNotBlank() }

    val startIndex =
        filteredChangelog.indexOfFirst { it.contains("## [") && !it.contains(unreleasedFlag) }

    val changelogToWrite = buildString {
        filteredChangelog.onEachIndexed { index, line ->
            when {
                !line.startsWith("###") && line.isNotBlank() -> appendLine(line + "\n")
                line.startsWith("###") && index < startIndex -> appendLine(line + "\n")
                line.startsWith("###") &&
                        filteredChangelog
                            .getOrNull(index + 1)
                            ?.startsWith("###") == true -> Unit
                line.startsWith("###") &&
                        filteredChangelog
                            .getOrNull(index + 1)
                            ?.startsWith("###") == false -> appendLine(line + "\n")
            }
        }
    }
    changelogFile.writeText(changelogToWrite)
}
