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
  //implementation(libs.dagger)
  //kapt(libs.dagger.compiler)
}