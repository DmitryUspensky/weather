package ru.uspensky.common.presentation.vm

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.lifecycle.ViewModel
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun Inject(
  viewModelFactory: VmFactory,
  content: @Composable () -> Unit
) {
  CompositionLocalProvider(
    LocalViewModelFactory provides viewModelFactory,
    content = content
  )
}

@Composable
inline fun <reified VM : ViewModel> daggerViewModel(): VM {
  val factory = getViewModelFactory()
  return viewModel {
    val savedStateHandle = createSavedStateHandle()
    factory.create(VM::class.java, savedStateHandle)
  }
}

@Composable
@PublishedApi
internal fun getViewModelFactory(): VmFactory {
  return checkNotNull(LocalViewModelFactory.current) {
    "No ViewModelFactory was provided via LocalViewModelFactory"
  }
}