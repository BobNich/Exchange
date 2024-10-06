plugins {
    alias(libs.plugins.exchange.android.library)
    alias(libs.plugins.exchange.android.compose)
}

android {
    namespace = "com.exchange.designsystem"
}

dependencies {
    api(libs.androidx.core.ktx)
    api(libs.androidx.compose.material.iconsExtended)
    api(libs.androidx.compose.material3)
    api(libs.androidx.compose.runtime)
    api(libs.androidx.compose.material3.adaptive.layout)
}
