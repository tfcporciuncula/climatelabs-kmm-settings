plugins {
  kotlin("multiplatform")
  id("com.android.library")
}

kotlin {
  android()
  ios()
  iosSimulatorArm64()

  sourceSets {
    val commonMain by getting {
      dependencies {
        api("com.russhwolf:multiplatform-settings:1.0.0-RC")
        api("com.russhwolf:multiplatform-settings-coroutines:1.0.0-RC")
        api("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
        api("org.jetbrains.kotlinx:kotlinx-datetime:0.4.0")
        implementation("me.tatarka.inject:kotlin-inject-runtime:0.5.1")
      }
    }
    val androidMain by getting {
      dependencies {
        api("androidx.datastore:datastore-preferences:1.0.0")
        implementation("com.russhwolf:multiplatform-settings-datastore:1.0.0-RC")
      }
    }
    val iosSimulatorArm64Main by getting
    val iosMain by getting {
      iosSimulatorArm64Main.dependsOn(this)
    }

    all {
      languageSettings {
        optIn("com.russhwolf.settings.ExperimentalSettingsApi")
        optIn("com.russhwolf.settings.ExperimentalSettingsImplementation")
      }
    }
  }
}

android {
  namespace = "de.climatelabs.kmmsettings.preferences"
  compileSdk = 33
  defaultConfig {
    minSdk = 26
    targetSdk = 33
  }
}
