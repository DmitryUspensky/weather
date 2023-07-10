package ru.uspensky.weather.activity

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import ru.uspensky.weather.presentation.navigation.showElements
import ru.uspensky.weatherApi.contracts.Event
import ru.uspensky.weatherApi.contracts.IElement
import ru.uspensky.weatherApi.contracts.Move
import ru.uspensky.weatherApi.contracts.Notice
import java.time.LocalDate

class WeatherActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      showElements(elements = generateElements())
    }
  }

  private fun generateElements(): List<IElement> {
    val count = (10..100).random()
    val elements = mutableListOf<IElement>()
    for (i in 1..count) {
      val element = when ((0..2).random()) {
        0 -> generateEvent()
        1 -> generateMove()
        2 -> generateNotice()
        else -> generateEvent()
      }
      elements.add(element)
    }
    return elements
  }

  private fun generateEvent(): Event {
    return Event(
      startTime = LocalDate.now(),
      endTime = LocalDate.now(),
      name = "name"
    )
  }

  private fun generateMove(): Move {
    val citiesFrom =
      listOf("Moscow", "Baku", "Brest", "Dacca", "Liverpool", "Mexico", "Osaka", "Tbilisi")
    val citiesTo =
      listOf("Tartu", "Tokyo", "Zurich", "Prague", "Narva", "Minsk", "Medellin", "Limassol")
    return Move(
      fromPlace = citiesFrom.random(),
      toPlace = citiesTo.random(),
      estimateTime = LocalDate.now()
    )
  }

  private fun generateNotice(): Notice {
    val gateChar = ('A'..'Z').random()
    val gateNumber = (1..30).random()
    return Notice(
      flightDate = LocalDate.now(),
      gate = "$gateChar$gateNumber"
    )
  }
}