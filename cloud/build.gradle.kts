plugins {
    alias(libs.plugins.exchange.android.library)
}

android {
    namespace = "com.exchange.cloud"
}

dependencies {
    implementation(platform(libs.okhttp.bom))
    implementation(libs.okhttp.core)
}
