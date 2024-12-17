plugins {
    alias(libs.plugins.convention.android.library)
    alias(libs.plugins.convention.android.hilt)
    alias(libs.plugins.convention.kotlin.serialization)
}

android {
    namespace = "com.exchange.feature.market.data"
}

dependencies {
    implementation(projects.cloud)
    implementation(projects.feature.market.domain)
    implementation(projects.core.account)
    implementation(libs.kotlinx.datetime)
}
