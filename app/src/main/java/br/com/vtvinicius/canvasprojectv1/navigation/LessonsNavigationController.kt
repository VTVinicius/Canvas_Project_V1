package br.com.vtvinicius.canvasprojectv1.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import androidx.navigation.compose.rememberNavController
import br.com.vtvinicius.canvasprojectv1.lessons.lesson1.BasicShapes
import br.com.vtvinicius.canvasprojectv1.lessons.lesson2.BallClickerGame
import br.com.vtvinicius.canvasprojectv1.lessons.lesson3.BasicCanvasText
import br.com.vtvinicius.canvasprojectv1.lessons.lesson4.WeightPickerScreen
import br.com.vtvinicius.canvasprojectv1.lessons.lesson5.ClockScreen
import br.com.vtvinicius.canvasprojectv1.lessons.lesson6.ClockScreenResolved
import br.com.vtvinicius.canvasprojectv1.lessons.lesson7.ExamplePath
import br.com.vtvinicius.canvasprojectv1.lessons.lesson8.CubicPath
import br.com.vtvinicius.canvasprojectv1.lessons.lesson8.QuadraticPath
import br.com.vtvinicius.canvasprojectv1.lobby.LobbyScreen

@Composable
fun LessonsNavigationController() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "lobby_screen"
    ) {
        composable("lobby_screen") {
            LobbyScreen(navController = navController)
        }

        composable("lesson_1") {
            BasicShapes()
        }
        composable("lesson_2") {
            BallClickerGame()
        }
        composable("lesson_3") {
            BasicCanvasText()
        }
        composable("lesson_4") {
            WeightPickerScreen()
        }
        composable("lesson_5") {
            ClockScreen()
        }
        composable("lesson_6") {
            ClockScreenResolved()
        }

        composable("lesson_7") {
            ExamplePath()
        }
        composable("lesson_8") {
            QuadraticPath()
        }
        composable("lesson_8_1") {
            CubicPath()
        }
    }

}