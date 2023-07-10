package ru.uspensky.weather.di.module

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.uspensky.common.presentation.vm.VmAssistedFactory
import ru.uspensky.common.presentation.vm.VmAssistedFactoryKey
import ru.uspensky.common.presentation.vm.VmFactoryModule
import ru.uspensky.weather.presentation.vm.WeatherVm

@Module(
  includes = [VmFactoryModule::class]
)
internal interface WeatherVmModule {

  @Binds
  @[IntoMap VmAssistedFactoryKey(WeatherVm::class)]
  fun bindsDetailEmailViewModelFactory(factory: WeatherVm.Factory): VmAssistedFactory<*>
}