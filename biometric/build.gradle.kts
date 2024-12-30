plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("plugin.parcelize")
}

android {
    namespace = "com.example.app2" // Add this line with your package name
    compileSdkVersion(34)

    defaultConfig {
        applicationId = "com.example.app2"
        minSdkVersion(21)
        targetSdkVersion(34)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        viewBinding = true
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.6.0")
    implementation("androidx.core:core-ktx:1.6.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")
    implementation("androidx.activity:activity-compose:1.3.1")
    implementation("androidx.compose.ui:ui:1.0.4")
    implementation("androidx.compose.ui:ui-graphics:1.0.4")
    implementation("androidx.compose.ui:ui-tooling-preview:1.0.4")
    implementation("com.google.android.material:material:1.4.0")

    // Add AppCompat and WebView dependencies
    implementation("androidx.appcompat:appcompat:1.3.1")
    implementation("androidx.webkit:webkit:1.4.0")

    // Add Biometric dependencies
    implementation("androidx.biometric:biometric:1.1.0")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.0.4")
    debugImplementation("androidx.compose.ui:ui-tooling:1.0.4")
    debugImplementation("androidx.compose.ui:ui-test-manifest:1.0.4")
}
