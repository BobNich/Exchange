plugins {
    alias(libs.plugins.convention.android.library)
    alias(libs.plugins.convention.android.hilt)
}

android {
    namespace = "com.exchange.feature.login.data"
}

dependencies {
    implementation(projects.cloud)
    implementation(projects.feature.login.domain)
    implementation(projects.core.account)
}
