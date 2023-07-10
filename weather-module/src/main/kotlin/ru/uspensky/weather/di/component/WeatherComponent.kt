package ru.uspensky.weather.di.component

import dagger.Component
import ru.uspensky.common.presentation.vm.VmFactory
import ru.uspensky.weather.di.module.WeatherDataModule
import ru.uspensky.weather.di.module.WeatherDomainModule
import ru.uspensky.weather.di.module.WeatherVmModule
import ru.uspensky.weather.di.scope.WeatherScope
import ru.uspensky.weatherApi.usecase.IWeatherModuleApi

@Component(
  dependencies = [],
  modules = [
    WeatherDomainModule::class,
    WeatherDataModule::class,
    WeatherVmModule::class
  ]
)
@WeatherScope
internal interface WeatherComponent : IWeatherModuleApi {

  @Component.Builder
  interface Builder {

    fun weatherDataModule(weatherDataModule: WeatherDataModule): Builder

    fun build(): WeatherComponent
  }

  fun getViewModelFactory(): VmFactory
}