package ru.uspensky.weather.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons.Filled
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ru.uspensky.common.presentation.vm.daggerViewModel
import ru.uspensky.weather.presentation.support.toComposeColor
import ru.uspensky.weather.presentation.vm.WeatherVm

@Composable
internal fun DetailsElementScreen(
  navController: NavHostController,
  elementId: Int
) {
  val viewModel: WeatherVm = daggerViewModel()
  val element = viewModel.weatherState[elementId]
  Scaffold(
    topBar = { TopBar(navController, element.getTitle()) },
    content = {
      it.calculateBottomPadding()
      Text(
        text = element.getDetails(),
        modifier = Modifier
          .fillMaxWidth()
          .fillMaxHeight()
          .background(color = element.getColor().toComposeColor())
          .padding(vertical = 70.dp)
      )
    }
  )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopBar(navController: NavHostController, title: String) {
  TopAppBar(
    title = { Text(text = title) },
    navigationIcon = {
      IconButton(onClick = { navController.navigateUp() }) {
        Icon(
          imageVector = Filled.ArrowBack,
          contentDescription = "back"
        )
      }
    }
  )
}
