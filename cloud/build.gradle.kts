plugins {
    alias(libs.plugins.exchange.android.library)
    alias(libs.plugins.exchange.android.hilt)
}

android {
    namespace = "com.exchange.cloud"
}

dependencies {
    implementation(platform(libs.okhttp.bom))
    implementation(libs.okhttp.core)
    implementation(libs.okhttp.logging)
    implementation(libs.kotlin.coroutines.android)
}
