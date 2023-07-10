package ru.uspensky.weatherLogic.data.repository

import ru.uspensky.weatherApi.contracts.IElement
import ru.uspensky.weatherLogic.data.datasource.IWeatherDataSource
import ru.uspensky.weatherLogic.domain.repository.IWeatherRepository
import javax.inject.Inject

class WeatherRepository @Inject constructor(
  private val weatherDataSource: IWeatherDataSource
) : IWeatherRepository {

  override fun getWeather(): List<IElement> {
    return weatherDataSource.getWeather()
  }
}