plugins {
    alias(libs.plugins.convention.android.library)
}

android {
    namespace = "com.exchange.core.network"
}

dependencies {
    implementation(platform(libs.okhttp.bom))
    api(libs.okhttp.core)
    api(libs.okhttp.logging)
    api(libs.retrofit.core)
}
