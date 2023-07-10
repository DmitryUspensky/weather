package ru.uspensky.weather.presentation.vm

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import ru.uspensky.common.presentation.vm.VmAssistedFactory
import ru.uspensky.weatherApi.contracts.IElement
import ru.uspensky.weatherApi.usecase.ILoadWeatherUseCase

internal class WeatherVm @AssistedInject constructor(
  private val loadWeatherUseCase: ILoadWeatherUseCase,
  @Assisted private val handle: SavedStateHandle
) : ViewModel() {

  val weatherState: List<IElement> = loadWeatherUseCase()

  @AssistedFactory
  interface Factory : VmAssistedFactory<WeatherVm>
}