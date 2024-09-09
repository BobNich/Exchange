package com.exchange

import com.android.build.gradle.BaseExtension
import com.exchange.libs
import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidUiTestConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            dependencies.apply {
                add("androidTestImplementation", libs.androidx.test.runner)
                add("androidTestImplementation", libs.androidx.test.rules)
                add("androidTestImplementation", libs.androidx.ui.test.junit4)
                add("debugImplementation", libs.androidx.ui.test.manifest)
            }

            extensions.configure(BaseExtension::class.java) { base ->
                with(base) {
                    defaultConfig {
                        it.testInstrumentationRunner =
                            "androidx.test.runner.AndroidJUnitRunner"
                    }
                }
            }
        }
    }
}
