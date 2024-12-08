plugins {
    kotlin("jvm")
    `java-gradle-plugin`
}

group = "com.exchange.android.build-logic"

dependencies {
    compileOnly(gradleApi())
    // workaround for https://github.com/gradle/gradle/issues/15383
    implementation(files((libs as Any).javaClass.superclass.protectionDomain.codeSource.location))
}

gradlePlugin {
    plugins {
        create("gradle-secrets") {
            id = "convention.gradle-secrets"
            implementationClass = "com.exchange.GradleSecretsConventionPlugin"
        }
    }
}
