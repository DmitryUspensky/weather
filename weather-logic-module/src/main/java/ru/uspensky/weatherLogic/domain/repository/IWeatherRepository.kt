package ru.uspensky.weatherLogic.domain.repository

import ru.uspensky.weatherApi.contracts.IElement

interface IWeatherRepository {

  fun getWeather(): List<IElement>
}