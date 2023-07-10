plugins {
  alias(libs.plugins.android.application)
  alias(libs.plugins.kotlin.android)
  kotlin("kapt")
}

android {
  namespace = "ru.uspensky.weather"
  compileSdk = 33

  defaultConfig {
    applicationId = "ru.uspensky.weather"
    minSdk = 24
    targetSdk = 33
    versionCode = 1
    versionName = "1.0"

    multiDexEnabled = true

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
  }

  buildTypes {
    release {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }

  @Suppress("UnstableApiUsage")
  buildFeatures {
    compose = true
  }

  composeOptions {
    kotlinCompilerExtensionVersion = "1.4.6"
  }

  // still need this above (AGP) version 8.1.0-alpha09 https://kotlinlang.org/docs/gradle-configure-project.html#gradle-java-toolchains-support
  compileOptions {
    isCoreLibraryDesugaringEnabled = true

    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
  }
}

kotlin {
  val javaVersion: Int by rootProject.extra
  jvmToolchain(javaVersion)
}

dependencies {
  implementation(project(":weather-api-module"))
  implementation(project(":weather-module"))
  // android
  implementation(libs.androidx.ktx)
  implementation(libs.androidx.appcompat)
  implementation(libs.android.material)
  // compose
  val composeBom = platform(libs.compose.bom)
  implementation(composeBom)
  androidTestImplementation(composeBom)
  // Material Design
  implementation("androidx.compose.material:material")
  implementation("androidx.compose.material3:material3")
  implementation("androidx.compose.ui:ui")
  // Android Studio Preview support
  implementation("androidx.compose.ui:ui-tooling-preview")
  debugImplementation("androidx.compose.ui:ui-tooling")
  // Optional - Integration with activities
  implementation("androidx.activity:activity-compose:1.6.1")
  // desugaring
  coreLibraryDesugaring(libs.core.library.desugaring)
}