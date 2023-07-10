plugins {
  `java-library`
  alias(libs.plugins.kotlin.jvm)
}

java {
  toolchain {
    val javaVersion: Int by rootProject.extra
    languageVersion.set(JavaLanguageVersion.of(javaVersion))
  }
}

dependencies {
  implementation(project(":weather-api-module"))
  // javax-inject
  implementation(libs.javax.inject)
  // dagger
  implementation(libs.dagger)
}