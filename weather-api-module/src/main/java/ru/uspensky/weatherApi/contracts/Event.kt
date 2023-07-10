package ru.uspensky.weatherApi.contracts

import ru.uspensky.weatherApi.contracts.IElement.ElementColor
import java.time.LocalDate

data class Event(
  var startTime: LocalDate? = null,
  var endTime: LocalDate? = null,
  var name: String? = null
) : IElement {

  override fun getTitle(): String = "Event"

  override fun getShortDescription() = "$name"

  override fun getDetails() = "start $startTime\nend $endTime\nname $name"

  override fun getColor(): ElementColor = ElementColor(
    red = 185,
    green = 217,
    blue = 180
  )
}