package com.exchange

import com.exchange.libs
import org.gradle.api.Plugin
import org.gradle.api.Project

class KspConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            plugins.apply(libs.plugins.ksp.get().pluginId)
        }
    }
}
