plugins {
    kotlin("jvm")
    `java-gradle-plugin`
}

group = "com.exchange.android.build-logic"

dependencies {
    implementation(projects.kotlin)
    implementation(projects.gradleExtension)
    implementation(libs.android.gradlePlugin)
    implementation(libs.ksp.gradlePlugin)
    implementation(libs.room.gradlePlugin)
    // workaround for https://github.com/gradle/gradle/issues/15383
    implementation(files((libs as Any).javaClass.superclass.protectionDomain.codeSource.location))
}

gradlePlugin {
    plugins {
        create("android-lib") {
            id = "convention.kotlin-android-library"
            implementationClass = "com.exchange.AndroidLibraryConventionPlugin"
        }

        create("android-app") {
            id = "convention.kotlin-android-app"
            implementationClass = "com.exchange.AndroidApplicationConventionPlugin"
        }

        create("android-compose") {
            id = "convention.android-compose"
            implementationClass = "com.exchange.compose.AndroidComposeConventionPlugin"
        }

        create("hilt") {
            id = "convention.hilt"
            implementationClass = "com.exchange.HiltConventionPlugin"
        }

        create("room") {
            id = "convention.room"
            implementationClass = "com.exchange.AndroidRoomConventionPlugin"
        }
    }
}
