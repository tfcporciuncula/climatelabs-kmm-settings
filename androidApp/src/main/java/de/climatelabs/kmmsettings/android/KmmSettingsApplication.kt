package de.climatelabs.kmmsettings.android

import android.app.Application
import de.climatelabs.kmmsettings.util.unsyncLazy

class KmmSettingsApplication : Application(), ApplicationComponentProvider {
  override val component by unsyncLazy { ApplicationComponent::class.create(applicationContext) }
}
