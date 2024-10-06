plugins {
    alias(libs.plugins.exchange.android.library)
}

android {
    namespace = "com.exchange.core"
}

dependencies {
    // core
    api(libs.kotlin.coroutines.android)
    // cloud
    implementation(platform(libs.okhttp.bom))
    api(libs.okhttp.core)
    api(libs.okhttp.logging)
}