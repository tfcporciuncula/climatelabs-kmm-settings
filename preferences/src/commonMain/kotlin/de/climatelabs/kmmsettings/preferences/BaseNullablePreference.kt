package de.climatelabs.kmmsettings.preferences

import com.russhwolf.settings.coroutines.FlowSettings

internal abstract class BaseNullablePreference<T>(
  private val settings: FlowSettings,
  private val key: String,
) : NullablePreference<T> {
  override suspend fun delete() = settings.remove(key)
  override suspend fun isSet() = settings.hasKey(key)
}
