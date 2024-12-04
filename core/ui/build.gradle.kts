plugins {
    alias(libs.plugins.convention.android.library)
    alias(libs.plugins.convention.android.compose)
    alias(libs.plugins.convention.kotlin.serialization)
}

android {
    namespace = "com.exchange.core.ui"
}

dependencies {
    implementation(libs.androidx.core.ktx)

    implementation(projects.designSystem)
}
