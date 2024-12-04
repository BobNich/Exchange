plugins {
    alias(libs.plugins.convention.android.library)
}

android {
    namespace = "com.exchange.core.network"
}

dependencies {
    // core
    api(libs.kotlin.coroutines.android)
    // cloud
    implementation(platform(libs.okhttp.bom))
    api(libs.okhttp.core)
    api(libs.okhttp.logging)
    api(libs.retrofit.core)
}
