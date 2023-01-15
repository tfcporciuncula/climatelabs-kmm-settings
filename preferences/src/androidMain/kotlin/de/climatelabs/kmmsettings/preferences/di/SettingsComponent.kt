package de.climatelabs.kmmsettings.preferences.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.russhwolf.settings.coroutines.FlowSettings
import com.russhwolf.settings.datastore.DataStoreSettings
import me.tatarka.inject.annotations.Provides

private val Context.preferences by preferencesDataStore("preferences")

actual interface SettingsComponent {
  @Provides
  fun provideDataStore(context: Context): DataStore<Preferences> {
    return context.preferences
  }

  @Provides @Singleton
  fun provideFlowSettings(dataStore: DataStore<Preferences>): FlowSettings {
    return DataStoreSettings(dataStore)
  }
}
