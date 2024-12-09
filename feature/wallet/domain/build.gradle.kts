plugins {
    alias(libs.plugins.convention.kotlin.jvm)
}

dependencies {
    api(projects.core.domain)
}
