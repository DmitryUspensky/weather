package ru.uspensky.weatherLogic.data.datasource

import ru.uspensky.weatherApi.contracts.IElement
import javax.inject.Inject

class NetworkWeatherDataSource @Inject constructor(
  private val elements: Elements
) : IWeatherDataSource {

  override fun getWeather(): List<IElement> {
    return elements.elements
  }
}