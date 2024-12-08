plugins {
    alias(libs.plugins.convention.android.library)
    alias(libs.plugins.convention.android.hilt)
    alias(libs.plugins.convention.kotlin.serialization)
}

android {
    namespace = "com.exchange.feature.settings.data"
}

dependencies {
    implementation(projects.feature.settings.domain)
    implementation(projects.core.account)
}
