package internal

import org.gradle.api.Project

internal val Project.isSignificant: Boolean
    get() =
        Regex(
                "^(0|[1-9]\\d*)\\.(0|[1-9]\\d*)\\.(0|[1-9]\\d*)(?:-((?:0|[1-9]\\d*|\\d*[a-zA-Z-]" +
                    "[0-9a-zA-Z-]*)(?:\\.(?:[1-9]\\d*|\\d*[a-zA-Z-][0-9]*))*))?(?:\\+([0-9]))?\$",
            )
            .matches(version.toString())
