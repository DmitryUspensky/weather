package ru.uspensky.weather.di.module

import dagger.Module
import dagger.Provides
import ru.uspensky.weather.di.scope.WeatherScope
import ru.uspensky.weatherLogic.data.datasource.Elements
import ru.uspensky.weatherLogic.data.datasource.IWeatherDataSource
import ru.uspensky.weatherLogic.data.datasource.NetworkWeatherDataSource
import ru.uspensky.weatherLogic.data.repository.WeatherRepository
import ru.uspensky.weatherLogic.domain.repository.IWeatherRepository

@Module
internal class WeatherDataModule(private val elements: Elements) {

  @WeatherScope
  @Provides
  fun provideWeatherDataSource(): IWeatherDataSource {
    return NetworkWeatherDataSource(elements)
  }

  @WeatherScope
  @Provides
  fun provideWeatherRepository(weatherDataSource: IWeatherDataSource): IWeatherRepository {
    return WeatherRepository(weatherDataSource)
  }
}
