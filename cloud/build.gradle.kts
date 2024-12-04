plugins {
    alias(libs.plugins.convention.android.library)
    alias(libs.plugins.convention.android.hilt)
    alias(libs.plugins.convention.kotlin.serialization)
}

android {
    namespace = "com.exchange.cloud"
}

dependencies {
    api(projects.core.network)
    implementation(libs.retrofit.converter.json)
    implementation(projects.core.account)
}
