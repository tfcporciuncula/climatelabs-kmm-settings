package de.climatelabs.kmmsettings.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import de.climatelabs.kmmsettings.util.unsyncLazy
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
  private val component by unsyncLazy {
    MainActivityComponent::class.create(applicationComponent)
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val testPreference = component.testPreference
    setContent {
      MyApplicationTheme {
        Surface(
          modifier = Modifier.fillMaxSize(),
          color = MaterialTheme.colors.background
        ) {
          Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
          ) {
            val preferenceValue by testPreference.asFlow().collectAsState(initial = testPreference.defaultValue)
            Text(text = "Preference value: $preferenceValue")

            val scope = rememberCoroutineScope()
            Button(
              onClick = {
                scope.launch { testPreference.set(testPreference.get() - 10) }
              }
            ) {
              Text(text = "Subtract 10 to preference value")
            }
            Button(
              onClick = {
                scope.launch { testPreference.set(testPreference.get() + 10) }
              }
            ) {
              Text(text = "Add 10 to preference value")
            }
          }
        }
      }
    }
  }
}
