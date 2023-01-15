package de.climatelabs.kmmsettings.android

import de.climatelabs.kmmsettings.preferences.di.TestPreference
import me.tatarka.inject.annotations.Component

@Component
abstract class MainActivityComponent(@Component val applicationComponent: ApplicationComponent) {
  abstract val testPreference: TestPreference
}
