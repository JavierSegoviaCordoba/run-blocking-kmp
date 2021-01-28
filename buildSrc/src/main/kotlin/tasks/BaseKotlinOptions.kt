package tasks

import org.gradle.api.JavaVersion
import org.gradle.kotlin.dsl.TaskContainerScope
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val TaskContainerScope.baseKotlinOptions: Unit
    get() {
        withType<KotlinCompile>().all {
            kotlinOptions {
                jvmTarget = JavaVersion.VERSION_1_8.toString()
                freeCompilerArgs = freeCompilerArgs + listOf(
                    "-Xinline-classes",
                    "-Xopt-in=kotlinx.coroutines.ExperimentalCoroutinesApi",
                    "-Xopt-in=kotlinx.coroutines.ObsoleteCoroutinesApi",
                    "-Xopt-in=kotlinx.coroutines.FlowPreview",
                    "-Xopt-in=kotlinx.serialization.ExperimentalSerializationApi",
                    "-Xopt-in=io.ktor.util.KtorExperimentalAPI"
                )
            }
        }
    }
