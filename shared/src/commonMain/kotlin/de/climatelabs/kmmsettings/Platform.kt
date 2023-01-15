package de.climatelabs.kmmsettings

interface Platform {
  val name: String
}

expect fun getPlatform(): Platform
