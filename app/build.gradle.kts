plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "ua.tryvoha.app"
    compileSdk = 35

    defaultConfig {
        applicationId = "ua.tryvoha.app"
        minSdk = 23
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
    }
}
