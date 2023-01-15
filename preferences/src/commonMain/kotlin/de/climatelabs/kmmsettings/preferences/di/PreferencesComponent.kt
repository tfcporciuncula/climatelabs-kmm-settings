package de.climatelabs.kmmsettings.preferences.di

import com.russhwolf.settings.coroutines.FlowSettings
import de.climatelabs.kmmsettings.preferences.IntPreference
import de.climatelabs.kmmsettings.preferences.Preference
import de.climatelabs.kmmsettings.preferences.StringPreference
import me.tatarka.inject.annotations.Provides

typealias TestPreference = Preference<Int>

interface PreferencesComponent : SettingsComponent {
  @Provides
  fun provideTestPreference(settings: FlowSettings): TestPreference {
    return IntPreference(settings, "test", defaultValue = 0)
  }
}

expect interface SettingsComponent
