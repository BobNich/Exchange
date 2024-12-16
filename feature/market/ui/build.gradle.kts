plugins {
    alias(libs.plugins.convention.android.library)
    alias(libs.plugins.convention.android.compose)
    alias(libs.plugins.convention.android.hilt)
    alias(libs.plugins.convention.kotlin.serialization)
}

android {
    namespace = "com.exchange.feature.market.ui"
}

dependencies {
    implementation(projects.core.ui)
    implementation(projects.designSystem)
    implementation(projects.feature.market.domain)
    implementation(libs.lottie.compose)
}
