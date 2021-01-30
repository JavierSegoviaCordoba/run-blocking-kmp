import org.jetbrains.changelog.closure
import org.jetbrains.changelog.date

plugins {
    id("org.jetbrains.changelog")
}

changelog {
    version = "${project.version}"
    header = closure { "[$version] - ${date()}" }
    keepUnreleasedSection = true
    unreleasedTerm = "[Unreleased]"
    groups = listOf("Added", "Changed", "Deprecated", "Removed", "Fixed", "Updated")
}

println("HELLO: ${project.version}")
