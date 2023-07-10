plugins {
  `java-library`
  alias(libs.plugins.kotlin.jvm)
  alias(libs.plugins.kotlin.serialization)
}

java {
  toolchain {
    val javaVersion: Int by rootProject.extra
    languageVersion.set(JavaLanguageVersion.of(javaVersion))
  }
}