package ru.uspensky.weather.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ru.uspensky.common.presentation.vm.daggerViewModel
import ru.uspensky.weather.presentation.support.toComposeColor
import ru.uspensky.weather.presentation.vm.WeatherVm

@Composable
internal fun ListElementsScreen(
  navController: NavHostController
) {
  val viewModel: WeatherVm = daggerViewModel()
  Scaffold {
    it.calculateBottomPadding()
    val elements = viewModel.weatherState
    LazyColumn {
      itemsIndexed(elements) { index, item ->
        Row(
          modifier = Modifier
            .fillMaxWidth()
            .background(color = item.getColor().toComposeColor())
            .clickable {
              navController.navigate(route = "details/$index")
            }
        ) {
          Column(
            modifier = Modifier
              .padding(start = 12.dp, top = 16.dp, bottom = 16.dp)
          ) {
            Text(
              text = item.getTitle(),
              fontWeight = FontWeight.Bold
            )
            Text(text = item.getShortDescription())
          }
        }
        if (index < elements.lastIndex)
          Divider(color = Color.White, thickness = 1.dp)
      }
    }
  }
}