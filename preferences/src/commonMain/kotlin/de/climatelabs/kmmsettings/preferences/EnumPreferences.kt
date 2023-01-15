package de.climatelabs.kmmsettings.preferences

import com.russhwolf.settings.coroutines.FlowSettings
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal inline fun <reified T : Enum<T>> EnumPreference(
  settings: FlowSettings,
  key: String,
  defaultValue: T,
): Preference<T> {
  return object : BasePreference<T>(settings, key) {
    override val defaultValue = defaultValue

    override suspend fun get(): T {
      return enumValueOf(settings.getString(key, defaultValue.toString()))
    }

    override suspend fun set(value: T) {
      settings.putString(key, value.name)
    }

    override fun asFlow(): Flow<T> {
      return settings.getStringFlow(key, defaultValue.name).map { enumValueOf(it) }
    }
  }
}

internal inline fun <reified T : Enum<T>> NullableEnumPreference(
  settings: FlowSettings,
  key: String,
): NullablePreference<T> {
  return object : BaseNullablePreference<T>(settings, key) {
    override suspend fun get(): T? {
      return settings.getStringOrNull(key)?.let { enumValueOf<T>(it) }
    }

    override suspend fun set(value: T) {
      settings.putString(key, value.name)
    }

    override fun asFlow(): Flow<T?> {
      return settings.getStringOrNullFlow(key).map { stringValue ->
        stringValue?.let { enumValueOf<T>(it) }
      }
    }
  }
}
