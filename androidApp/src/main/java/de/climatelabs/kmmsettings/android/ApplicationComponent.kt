package de.climatelabs.kmmsettings.android

import android.content.Context
import de.climatelabs.kmmsettings.preferences.di.PreferencesComponent
import de.climatelabs.kmmsettings.preferences.di.Singleton
import me.tatarka.inject.annotations.Component
import me.tatarka.inject.annotations.Provides

@Component
@Singleton
abstract class ApplicationComponent(
  @get:Provides val applicationContext: Context,
) : PreferencesComponent

interface ApplicationComponentProvider {
  val component: ApplicationComponent
}

val Context.applicationComponent get() = (applicationContext as ApplicationComponentProvider).component
