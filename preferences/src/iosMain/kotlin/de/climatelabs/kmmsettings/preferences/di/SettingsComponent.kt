package de.climatelabs.kmmsettings.preferences.di

import com.russhwolf.settings.NSUserDefaultsSettings
import com.russhwolf.settings.coroutines.FlowSettings
import com.russhwolf.settings.coroutines.toFlowSettings
import me.tatarka.inject.annotations.Provides

actual interface SettingsComponent {
  @Provides @Singleton
  fun provideFlowSettings(): FlowSettings {
    return NSUserDefaultsSettings.Factory().create("preferences").toFlowSettings()
  }
}
