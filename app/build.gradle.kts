plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("plugin.serialization") version "1.5.31"
}

android {
    namespace = "com.example.oogartsapp"
    compileSdk = 34

    buildFeatures {
        dataBinding = true
        compose = true
    }

    defaultConfig {
        applicationId = "com.example.oogartsapp"
        minSdk = 31
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        manifestPlaceholders["auth0Domain"] = "@string/com_auth0_domain"
        manifestPlaceholders["auth0Scheme"] = "demo"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }

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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.5.31")
    implementation("androidx.core:core-ktx:1.10.0")
    implementation("io.coil-kt:coil-compose:1.4.0")
    implementation("androidx.appcompat:appcompat:1.6.0")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.auth0.android:auth0:2.9.2")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.7.2")
    implementation("androidx.compose.ui:ui:1.1.0")
    implementation("androidx.compose.ui:ui-graphics:1.1.0")
    implementation("androidx.compose.ui:ui-tooling-preview:1.1.0")
    implementation("androidx.compose.material3:material3:1.1.0")
    implementation("androidx.navigation:navigation-compose:2.7.4")
    implementation("androidx.constraintlayout:constraintlayout-compose:1.0.1")
    implementation("androidx.compose.material:material-icons-core:1.5.4")
    implementation("androidx.compose.material:material-icons-extended:1.5.4")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.0")
    implementation("com.google.code.gson:gson:2.8.8")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.0")
    implementation("com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2")
    implementation("com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:1.0.0")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.1")
    implementation("com.squareup.okhttp3:okhttp:4.9.1")
    implementation("com.squareup.moshi:moshi-kotlin:1.12.0")
    implementation("junit:junit:4.13.2")
    implementation("androidx.test.ext:junit:1.1.5")
    implementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation("androidx.compose.ui:ui-test-junit4:1.1.0")
    debugImplementation("androidx.compose.ui:ui-tooling:1.1.0")
    debugImplementation("androidx.compose.ui:ui-test-manifest:1.1.0")
}