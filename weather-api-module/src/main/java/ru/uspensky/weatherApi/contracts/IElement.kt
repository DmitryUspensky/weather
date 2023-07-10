package ru.uspensky.weatherApi.contracts

interface IElement {

  fun getTitle(): String

  fun getShortDescription(): String

  fun getDetails(): String

  fun getColor(): ElementColor = ElementColor(red = 255, green = 255, blue = 255)

  data class ElementColor(
    val red: Int,
    val green: Int,
    val blue: Int
  )
}