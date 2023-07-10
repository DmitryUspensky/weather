package ru.uspensky.weatherApi.contracts

import ru.uspensky.weatherApi.contracts.IElement.ElementColor
import java.time.LocalDate

data class Move(
  var fromPlace: String? = null,
  var toPlace: String? = null,
  var estimateTime: LocalDate? = null
) : IElement {

  override fun getTitle(): String = "Move"

  override fun getShortDescription() = "$fromPlace -> $toPlace"

  override fun getDetails() = "from $fromPlace\nto $toPlace\ntime $estimateTime"

  override fun getColor(): ElementColor = ElementColor(
    red = 180,
    green = 182,
    blue = 217
  )
}