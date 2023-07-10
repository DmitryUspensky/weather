import org.jetbrains.kotlin.gradle.dsl.kotlinExtension

plugins {
  alias(libs.plugins.android.library)
  alias(libs.plugins.kotlin.android)
  kotlin("kapt")
}

android {
  namespace = "ru.uspensky.weather"
  compileSdk = 33

  defaultConfig {
    multiDexEnabled = true
  }

  buildTypes {
    getByName("release") {
      isMinifyEnabled = true
      proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
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
  implementation(project(":weather-logic-module"))
  implementation(project(":di-module"))
  implementation(project(":common-module"))
  // android
  implementation(libs.androidx.ktx)
  implementation(libs.androidx.appcompat)
  implementation(libs.android.material)
  // compose
  val composeBom = platform(libs.compose.bom)
  implementation(composeBom)
  androidTestImplementation(composeBom)
  // Material Design 3
  implementation("androidx.compose.material3:material3")
  implementation("androidx.compose.ui:ui")
  // compose navigation
  implementation(libs.compose.navigation)
  // Android Studio Preview support
  implementation("androidx.compose.ui:ui-tooling-preview")
  debugImplementation("androidx.compose.ui:ui-tooling")
  // dagger
  implementation(libs.dagger)
  kapt(libs.dagger.compiler)
  // desugaring
  coreLibraryDesugaring(libs.core.library.desugaring)
}