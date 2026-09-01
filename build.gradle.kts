plugins {
    id("com.android.application") version "9.3.2"
}

repositories {
    mavenLocal()
    mavenCentral()
    google()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(11))
    }
}

android {
    compileSdk = 35
    ndkVersion = "28.2.13676358"
    namespace = "uk.co.baconi.playground.raylib"
    buildFeatures {
        buildConfig = true
    }
    defaultConfig {
        minSdk = 26
        targetSdk = 35
        versionCode = 3
        versionName = "0.0.3"
        externalNativeBuild {
            cmake {
                arguments += listOf("-DPLATFORM=Android")
                targets += listOf("playground_raylib")
            }
        }
    }
    externalNativeBuild {
        cmake {
            version = "4.1.2"
            path = file("CMakeLists.txt")
        }
    }
}