plugins {
    alias(libs.plugins.convention.android.application)
    alias(libs.plugins.convention.android.compose)
    alias(libs.plugins.convention.android.hilt)
    alias(libs.plugins.convention.kotlin.serialization)
    alias(libs.plugins.convention.android.unit.test)
    alias(libs.plugins.convention.android.ui.test)
    alias(libs.plugins.convention.signing)
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
            manifestPlaceholders["http"] = "true"
        }
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            manifestPlaceholders["http"] = "false"
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
    implementation(libs.androidx.core.splashscreen)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)

    implementation(libs.androidx.compose.material3)

    implementation(projects.designSystem)
    implementation(projects.core.ui)
    implementation(projects.core.account)
    implementation(projects.feature.login.ui)
    implementation(projects.feature.login.data)
    implementation(projects.feature.signup.ui)
    implementation(projects.feature.signup.data)
    implementation(projects.feature.wallet.ui)
    implementation(projects.feature.wallet.data)
    implementation(projects.feature.settings.ui)
    implementation(projects.feature.settings.data)
    implementation(projects.feature.market.ui)
    implementation(projects.feature.market.data)
    implementation(projects.feature.buy.ui)
    implementation(projects.feature.buy.data)
    implementation(projects.feature.sell.ui)
    implementation(projects.feature.sell.data)
}
