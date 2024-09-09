package com.exchange

import org.gradle.api.Plugin
import org.gradle.api.Project

class HiltConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            plugins.apply(libs.plugins.hilt.get().pluginId)
            plugins.apply(KspConventionPlugin::class.java)

            dependencies.apply {
                add("ksp", libs.hilt.compiler.get())
                add("implementation", libs.hilt.android.get())
            }
        }
    }
}
