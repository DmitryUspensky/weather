package ru.uspensky.weather.presentation.support

import androidx.compose.ui.graphics.Color
import ru.uspensky.weatherApi.contracts.IElement.ElementColor

internal fun ElementColor.toComposeColor(): Color {
  return Color(
    red = red, green = green, blue = blue,
  )
}