plugins {
    kotlin("jvm")
    `java-gradle-plugin`
}

group = "com.exchange.android.build-logic"

dependencies {
    implementation(projects.gradleExtension)
    implementation(libs.kotlin.gradlePlugin)
    implementation(libs.ksp.gradlePlugin)
    // workaround for https://github.com/gradle/gradle/issues/15383
    implementation(files((libs as Any).javaClass.superclass.protectionDomain.codeSource.location))
}

gradlePlugin {
    plugins {
        create("kotlin-jvm") {
            id = "convention.kotlin-jvm"
            implementationClass = "com.exchange.jvm.KotlinJvmPlugin"
        }

        create("kotlin-jvm-android") {
            id = "convention.kotlin-jvm-android"
            implementationClass = "com.exchange.jvm.KotlinJvmAndroidPlugin"
        }

        create("ksp") {
            id = "convention.ksp"
            implementationClass = "com.exchange.KspConventionPlugin"
        }

        create("serialization") {
            id = "convention.serialization"
            implementationClass = "com.exchange.KotlinSerializationConventionPlugin"
        }
    }
}
