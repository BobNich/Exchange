plugins {
    alias(libs.plugins.exchange.android.application)
    alias(libs.plugins.exchange.android.compose)
    alias(libs.plugins.exchange.android.hilt)
    alias(libs.plugins.exchange.android.unit.test)
    alias(libs.plugins.exchange.android.ui.test)
}

android {
    namespace = "com.exchange"

    defaultConfig {
        applicationId = "com.exchange"
        versionCode = 1
        versionName = "1.0"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        debug {
            isMinifyEnabled = false
            applicationIdSuffix = ".debug"
        }
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)

    implementation(projects.designSystem)
}
