import org.gradle.api.JavaVersion

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("org.jetbrains.kotlin.kapt")
    id("com.google.devtools.ksp") version "2.0.0-1.0.21"
    id("kotlin-parcelize")
}

android {
    namespace = "com.lochan.mynote"
    compileSdk {
        version = release(36) {
            minorApiLevel = 1
        }
    }

    defaultConfig {
        applicationId = "com.lochan.mynote"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        viewBinding = true
    }
}


dependencies {
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.core.ktx)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)

implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.9.4")
implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.9.4")

implementation ("androidx.room:room-runtime:2.8.3")
kapt ("androidx.room:room-compiler:2.8.3")
implementation ("androidx.room:room-ktx:2.8.3")

implementation ("androidx.recyclerview:recyclerview:1.4.0")
implementation ("com.google.android.material:material:1.13.0")

implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
}
