plugins {
    kotlin("jvm")
    `java-gradle-plugin`
}

group = "com.exchange.android.build-logic"

dependencies {
    implementation(libs.android.gradlePlugin)
}

gradlePlugin {
    plugins {
        create("signing") {
            id = "convention.signing"
            implementationClass = "com.exchange.AndroidApplicationSignConventionPlugin"
        }
    }
}
