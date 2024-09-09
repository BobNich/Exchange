package com.exchange.android

import com.exchange.KotlinBaseConventionPlugin
import com.exchange.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.jvm.toolchain.JavaLanguageVersion
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

class KotlinAndroidBaseConventionPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        with(project) {
            plugins.apply("kotlin-android")
            plugins.apply(KotlinBaseConventionPlugin::class.java)
            extensions.configure(KotlinAndroidProjectExtension::class.java) { kotlin ->
                kotlin.jvmToolchain {
                    it.languageVersion.set(JavaLanguageVersion.of(libs.versions.java.get()))
                }
            }

            tasks.withType(KotlinCompile::class.java).configureEach {
                it.compilerOptions {
                    jvmTarget.set(JvmTarget.JVM_1_8)
                }
            }
        }
    }
}
