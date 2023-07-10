package ru.uspensky.common.presentation.vm

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

interface VmFactory {

  fun <VM : ViewModel> create(modelClass: Class<VM>, handle: SavedStateHandle): VM
}