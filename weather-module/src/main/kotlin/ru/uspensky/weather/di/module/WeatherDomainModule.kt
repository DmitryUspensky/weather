package ru.uspensky.weather.di.module

import dagger.Binds
import dagger.Module
import ru.uspensky.weather.di.scope.WeatherScope
import ru.uspensky.weatherApi.usecase.ILoadWeatherUseCase
import ru.uspensky.weatherLogic.domain.usecase.LoadWeatherUseCase

@Module
internal interface WeatherDomainModule {

  @WeatherScope
  @Binds
  fun bindsLoadWeatherUseCase(loadWeatherUseCase: LoadWeatherUseCase): ILoadWeatherUseCase
}