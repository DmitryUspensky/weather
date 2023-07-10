package ru.uspensky.weather.di.module

import dagger.Module
import ru.uspensky.weatherLogic.data.datasource.Elements

@Module
internal class WeatherElementsModule(private val elements: Elements)