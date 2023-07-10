pluginManagement {
  plugins {
    kotlin("jvm") version "1.8.20"
  }

  repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
  }
}
dependencyResolutionManagement {
  repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
  repositories {
    google()
    mavenCentral()
  }
}
rootProject.name = "Weather"
include(
  ":app",
  ":di-module",
  ":weather-module",
  ":weather-logic-module",
  ":weather-api-module",
  ":common-module"
)