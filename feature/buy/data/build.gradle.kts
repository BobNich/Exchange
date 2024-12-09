plugins {
    alias(libs.plugins.convention.android.library)
    alias(libs.plugins.convention.android.hilt)
    alias(libs.plugins.convention.kotlin.serialization)
}

android {
    namespace = "com.exchange.feature.buy.data"
}

dependencies {
    implementation(projects.cloud)
    implementation(projects.feature.buy.domain)
    implementation(projects.core.account)
}
