package de.climatelabs.kmmsettings.preferences

import com.russhwolf.settings.coroutines.FlowSettings

internal abstract class BasePreference<T>(
  private val settings: FlowSettings,
  private val key: String,
) : Preference<T> {
  override suspend fun delete() = settings.remove(key)
  override suspend fun isSet() = settings.hasKey(key)
}
