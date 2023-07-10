package ru.uspensky.common.presentation.vm

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

@Target(
  AnnotationTarget.FUNCTION,
  AnnotationTarget.PROPERTY_GETTER,
  AnnotationTarget.PROPERTY_SETTER
)
@MapKey
annotation class VmAssistedFactoryKey(val value: KClass<out ViewModel>)