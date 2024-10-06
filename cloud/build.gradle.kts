plugins {
    alias(libs.plugins.exchange.android.library)
    alias(libs.plugins.exchange.android.hilt)
}

android {
    namespace = "com.exchange.cloud"
}

dependencies {
    implementation(projects.core)
}
