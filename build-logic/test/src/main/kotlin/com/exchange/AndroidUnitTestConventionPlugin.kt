package com.exchange

import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidUnitTestConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            dependencies.apply {
                add("testImplementation", libs.junit.get())
            }
        }
    }
}
