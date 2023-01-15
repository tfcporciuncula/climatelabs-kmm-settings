package de.climatelabs.kmmsettings.preferences

import kotlinx.coroutines.flow.Flow

interface NullablePreference<T> {
  suspend fun get(): T?
  suspend fun set(value: T)
  suspend fun delete()
  suspend fun isSet(): Boolean
  fun asFlow(): Flow<T?>
}
