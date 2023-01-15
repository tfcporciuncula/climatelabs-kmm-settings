package de.climatelabs.kmmsettings.preferences

import com.russhwolf.settings.coroutines.FlowSettings
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.datetime.Instant

internal class InstantPreference(
  private val settings: FlowSettings,
  private val key: String,
  override val defaultValue: Instant,
) : BasePreference<Instant>(settings, key) {
  override suspend fun get(): Instant {
    return Instant.parse(settings.getString(key, defaultValue.toString()))
  }

  override suspend fun set(value: Instant) {
    settings.putString(key, value.toString())
  }

  override fun asFlow(): Flow<Instant> {
    return settings.getStringFlow(key, defaultValue.toString()).map { Instant.parse(it) }
  }
}

internal class NullableInstantPreference(
  private val settings: FlowSettings,
  private val key: String,
) : BaseNullablePreference<Instant>(settings, key) {
  override suspend fun get(): Instant? {
    return settings.getStringOrNull(key)?.let { Instant.parse(it) }
  }

  override suspend fun set(value: Instant) {
    settings.putString(key, value.toString())
  }

  override fun asFlow(): Flow<Instant?> {
    return settings.getStringOrNullFlow(key).map { stringValue ->
      stringValue?.let { Instant.parse(it) }
    }
  }
}
