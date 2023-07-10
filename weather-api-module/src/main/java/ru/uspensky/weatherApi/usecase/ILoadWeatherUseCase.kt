package ru.uspensky.weatherApi.usecase

import ru.uspensky.weatherApi.contracts.IElement

interface ILoadWeatherUseCase {

  operator fun invoke(): List<IElement>
}