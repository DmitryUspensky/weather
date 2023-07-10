package ru.uspensky.di

interface IDiAppDelegate<T, R> {

  fun initDi(dependencies: R): T
}
