package com.exchange

import com.exchange.libs
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
