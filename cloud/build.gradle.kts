plugins {
    alias(libs.plugins.convention.android.library)
    alias(libs.plugins.convention.android.hilt)
    alias(libs.plugins.convention.kotlin.serialization)
    alias(libs.plugins.convention.gradle.secrets)
}

android {
    namespace = "com.exchange.cloud"

    buildFeatures {
        buildConfig = true
    }
}

secrets {
    defaultPropertiesFileName = "secrets.defaults.properties"
}

dependencies {
    api(projects.core.network)
    implementation(libs.retrofit.converter.json)
    implementation(projects.core.account)
}
