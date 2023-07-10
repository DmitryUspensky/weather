package ru.uspensky.common.presentation.vm

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidedValue
import androidx.compose.runtime.compositionLocalOf

object LocalViewModelFactory {

  private val LocalViewModelFactory =
    compositionLocalOf<VmFactory?> { null }

  val current: VmFactory?
    @Composable
    get() = LocalViewModelFactory.current

  infix fun provides(viewModelFactory: VmFactory):
      ProvidedValue<VmFactory?> {
    return LocalViewModelFactory.provides(viewModelFactory)
  }
}