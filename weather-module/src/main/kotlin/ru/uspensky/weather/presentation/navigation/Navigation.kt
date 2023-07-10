package ru.uspensky.weather.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import ru.uspensky.common.presentation.vm.Inject
import ru.uspensky.weather.WeatherAppDelegate
import ru.uspensky.weather.di.component.WeatherComponent
import ru.uspensky.weather.presentation.screen.DetailsElementScreen
import ru.uspensky.weather.presentation.screen.ListElementsScreen
import ru.uspensky.weatherApi.contracts.IElement

@Composable
fun showElements(elements: List<IElement>) {
  val navController = rememberNavController()
  NavHost(
    navController = navController,
    startDestination = "list"
  ) {
    composable(route = "list") {
      Inject((WeatherAppDelegate.initDi(elements) as WeatherComponent).getViewModelFactory()) {
        ListElementsScreen(
          navController = navController
        )
      }
    }
    composable(
      route = "details/{id}",
      arguments = listOf(
        navArgument("id") {
          type = NavType.IntType
        }
      )
    ) {
      val id = it.arguments?.getInt("id") ?: return@composable
      Inject((WeatherAppDelegate.initDi(elements) as WeatherComponent).getViewModelFactory()) {
        DetailsElementScreen(
          navController = navController,
          elementId = id
        )
      }
    }
  }
}