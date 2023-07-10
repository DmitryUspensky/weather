package ru.uspensky.weatherApi.contracts

import ru.uspensky.weatherApi.contracts.IElement.ElementColor
import java.time.LocalDate

data class Notice(
  val flightDate: LocalDate? = null,
  val gate: String? = null
) : IElement {

  override fun getTitle(): String = "Notice"

  override fun getShortDescription() = "$flightDate"

  override fun getDetails() = "date $flightDate\ngate $gate"

  override fun getColor(): ElementColor = ElementColor(
    red = 217,
    green = 180,
    blue = 188
  )
}