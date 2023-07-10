package ru.uspensky.common.presentation.vm

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

interface VmAssistedFactory<T : ViewModel> {

  fun create(handle: SavedStateHandle): T
}