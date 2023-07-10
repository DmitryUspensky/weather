plugins {
  alias(libs.plugins.android.library)
  alias(libs.plugins.kotlin.android)
  kotlin("kapt")
}

android {
  namespace = "ru.uspensky.common"
  compileSdk = 33

  @Suppress("UnstableApiUsage")
  buildFeatures {
    compose = true
  }

  composeOptions {
    kotlinCompilerExtensionVersion = "1.4.6"
  }

  // still need this above (AGP) version 8.1.0-alpha09 https://kotlinlang.org/docs/gradle-configure-project.html#gradle-java-toolchains-support
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
  }
}

dependencies {
  // dagger
  implementation(libs.dagger)
  kapt(libs.dagger.compiler)
  // android
  implementation(libs.androidx.ktx)
  implementation(libs.androidx.appcompat)
  implementation(libs.androidx.lifecycle.viewmodel)
  implementation(libs.android.material)

}