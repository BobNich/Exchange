plugins {
    alias(libs.plugins.convention.android.library)
    alias(libs.plugins.convention.android.compose)
}

android {
    namespace = "com.exchange.core.ui"
}

dependencies {
    api(libs.androidx.core.ktx)
    api(libs.androidx.lifecycle.viewmodel.ktx)
    api(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.javax.inject)

    implementation(projects.designSystem)
}
