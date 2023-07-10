package ru.uspensky.weatherLogic.data.datasource

import ru.uspensky.weatherApi.contracts.IElement

interface IWeatherDataSource {

  fun getWeather(): List<IElement>
}

data class Elements(
  val elements: List<IElement>
)