plugins {
    alias(libs.plugins.convention.android.library)
    alias(libs.plugins.convention.android.hilt)
    alias(libs.plugins.convention.kotlin.serialization)
}

android {
    namespace = "com.exchange.feature.wallet.data"
}

dependencies {
    implementation(projects.cloud)
    implementation(projects.feature.wallet.domain)
    implementation(projects.core.account)
}
