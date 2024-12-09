@file:Suppress("UnstableApiUsage")

rootProject.name = "Exchange"

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

includeBuild("build-logic")

include(":app")

include(":core:domain")

include(":core:network")
include(":cloud")
include(":cache")

include(":core:account")

include(":core:ui")
include(":design-system")

include(":feature:signup:data")
include(":feature:signup:domain")
include(":feature:signup:ui")

include(":feature:login:data")
include(":feature:login:domain")
include(":feature:login:ui")

include(":feature:wallet:data")
include(":feature:wallet:domain")
include(":feature:wallet:ui")

include(":feature:settings:data")
include(":feature:settings:domain")
include(":feature:settings:ui")

include(":feature:market:data")
include(":feature:market:domain")
include(":feature:market:ui")

include(":feature:sell:data")
include(":feature:sell:domain")
include(":feature:sell:ui")

include(":feature:buy:data")
include(":feature:buy:domain")
include(":feature:buy:ui")
