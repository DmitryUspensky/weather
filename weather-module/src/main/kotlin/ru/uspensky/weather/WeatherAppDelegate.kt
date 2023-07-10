package ru.uspensky.weather

import ru.uspensky.di.IDiAppDelegate
import ru.uspensky.weather.di.WeatherComponentManager
import ru.uspensky.weatherApi.contracts.IElement
import ru.uspensky.weatherApi.usecase.IWeatherModuleApi
import ru.uspensky.weatherLogic.data.datasource.Elements

internal object WeatherAppDelegate : IDiAppDelegate<IWeatherModuleApi, List<IElement>> {

  private lateinit var componentManager: WeatherComponentManager

  override fun initDi(elements: List<IElement>): IWeatherModuleApi {
    componentManager = WeatherComponentManager(Elements(elements))
    return componentManager.plusWeatherComponent()
  }
}