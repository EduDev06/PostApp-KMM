
plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    kotlin("plugin.serialization") version "1.9.21"
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "Shared"
            isStatic = true
        }
    }
    
    sourceSets {
        commonMain.dependencies {
            // Ktor
            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.serialization)
            implementation(libs.ktor.client.content.negotiation)

            // Coroutines
            implementation(libs.kotlinx.coroutines.core)

            // Koin
            api(libs.koin.core)
        }
        androidMain.dependencies {
            // Ktor
            implementation(libs.ktor.android)

            // Koin
            api(libs.koin.android)
        }
        iosMain.dependencies {
            implementation(libs.ktor.darwin)
        }
    }
}

android {
    namespace = "org.example.tasktest.shared"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
}
