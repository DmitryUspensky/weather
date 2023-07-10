package ru.uspensky.common.presentation.vm

import dagger.Binds
import dagger.Module

@Module
interface VmFactoryModule {

  @Binds
  fun bindsDaggerViewModelAssistedFactory(factory: VmFactoryImpl): VmFactory
}