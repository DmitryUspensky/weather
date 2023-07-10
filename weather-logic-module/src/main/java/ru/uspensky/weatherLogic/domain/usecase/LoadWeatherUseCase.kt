package ru.uspensky.weatherLogic.domain.usecase

import ru.uspensky.weatherApi.contracts.IElement
import ru.uspensky.weatherApi.usecase.ILoadWeatherUseCase
import ru.uspensky.weatherLogic.domain.repository.IWeatherRepository
import javax.inject.Inject

class LoadWeatherUseCase @Inject constructor(
  private val weatherRepository: IWeatherRepository
) : ILoadWeatherUseCase {

  override fun invoke(): List<IElement> = weatherRepository.getWeather()
}