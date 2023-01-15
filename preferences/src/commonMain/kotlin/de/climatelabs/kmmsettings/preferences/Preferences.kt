package de.climatelabs.kmmsettings.preferences

import com.russhwolf.settings.coroutines.FlowSettings

internal class BooleanPreference(
  private val settings: FlowSettings,
  private val key: String,
  override val defaultValue: Boolean,
) : BasePreference<Boolean>(settings, key) {
  override suspend fun get() = settings.getBoolean(key, defaultValue)
  override suspend fun set(value: Boolean) = settings.putBoolean(key, value)
  override fun asFlow() = settings.getBooleanFlow(key, defaultValue)
}

internal class NullableBooleanPreference(
  private val settings: FlowSettings,
  private val key: String,
) : BaseNullablePreference<Boolean>(settings, key) {
  override suspend fun get() = settings.getBooleanOrNull(key)
  override suspend fun set(value: Boolean) = settings.putBoolean(key, value)
  override fun asFlow() = settings.getBooleanOrNullFlow(key)
}

internal class IntPreference(
  private val settings: FlowSettings,
  private val key: String,
  override val defaultValue: Int,
) : BasePreference<Int>(settings, key) {
  override suspend fun get() = settings.getInt(key, defaultValue)
  override suspend fun set(value: Int) = settings.putInt(key, value)
  override fun asFlow() = settings.getIntFlow(key, defaultValue)
}

internal class NullableIntPreference(
  private val settings: FlowSettings,
  private val key: String,
) : BaseNullablePreference<Int>(settings, key) {
  override suspend fun get() = settings.getIntOrNull(key)
  override suspend fun set(value: Int) = settings.putInt(key, value)
  override fun asFlow() = settings.getIntOrNullFlow(key)
}

internal class LongPreference(
  private val settings: FlowSettings,
  private val key: String,
  override val defaultValue: Long,
) : BasePreference<Long>(settings, key) {
  override suspend fun get() = settings.getLong(key, defaultValue)
  override suspend fun set(value: Long) = settings.putLong(key, value)
  override fun asFlow() = settings.getLongFlow(key, defaultValue)
}

internal class NullableLongPreference(
  private val settings: FlowSettings,
  private val key: String,
) : BaseNullablePreference<Long>(settings, key) {
  override suspend fun get() = settings.getLongOrNull(key)
  override suspend fun set(value: Long) = settings.putLong(key, value)
  override fun asFlow() = settings.getLongOrNullFlow(key)
}

internal class FloatPreference(
  private val settings: FlowSettings,
  private val key: String,
  override val defaultValue: Float,
) : BasePreference<Float>(settings, key) {
  override suspend fun get() = settings.getFloat(key, defaultValue)
  override suspend fun set(value: Float) = settings.putFloat(key, value)
  override fun asFlow() = settings.getFloatFlow(key, defaultValue)
}

internal class NullableFloatPreference(
  private val settings: FlowSettings,
  private val key: String,
) : BaseNullablePreference<Float>(settings, key) {
  override suspend fun get() = settings.getFloatOrNull(key)
  override suspend fun set(value: Float) = settings.putFloat(key, value)
  override fun asFlow() = settings.getFloatOrNullFlow(key)
}

internal class DoublePreference(
  private val settings: FlowSettings,
  private val key: String,
  override val defaultValue: Double,
) : BasePreference<Double>(settings, key) {
  override suspend fun get() = settings.getDouble(key, defaultValue)
  override suspend fun set(value: Double) = settings.putDouble(key, value)
  override fun asFlow() = settings.getDoubleFlow(key, defaultValue)
}

internal class NullableDoublePreference(
  private val settings: FlowSettings,
  private val key: String,
) : BaseNullablePreference<Double>(settings, key) {
  override suspend fun get() = settings.getDoubleOrNull(key)
  override suspend fun set(value: Double) = settings.putDouble(key, value)
  override fun asFlow() = settings.getDoubleOrNullFlow(key)
}

internal class StringPreference(
  private val settings: FlowSettings,
  private val key: String,
  override val defaultValue: String,
) : BasePreference<String>(settings, key) {
  override suspend fun get() = settings.getString(key, defaultValue)
  override suspend fun set(value: String) = settings.putString(key, value)
  override fun asFlow() = settings.getStringFlow(key, defaultValue)
}

internal class NullableStringPreference(
  private val settings: FlowSettings,
  private val key: String,
) : BaseNullablePreference<String>(settings, key) {
  override suspend fun get() = settings.getStringOrNull(key)
  override suspend fun set(value: String) = settings.putString(key, value)
  override fun asFlow() = settings.getStringOrNullFlow(key)
}
