package ru.uspensky.weather.di

import ru.uspensky.weather.di.component.DaggerWeatherComponent
import ru.uspensky.weather.di.component.WeatherComponent
import ru.uspensky.weather.di.module.WeatherDataModule
import ru.uspensky.weatherLogic.data.datasource.Elements

internal class WeatherComponentManager(private val elements: Elements) {

  private var weatherComponent: WeatherComponent? = null

  @Synchronized
  fun plusWeatherComponent(): WeatherComponent {
    return weatherComponent ?: DaggerWeatherComponent
      .builder()
      .weatherDataModule(WeatherDataModule(elements))
      .build()
      .also { weatherComponent = it }
  }

  @Synchronized
  fun destroyWeatherComponent() {
    weatherComponent = null
  }
}