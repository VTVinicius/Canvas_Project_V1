package br.com.vtvinicius.canvasprojectv1.lobby

import android.annotation.SuppressLint
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun LobbyScreen(navController: NavController) {

    Scaffold(
        content = {


            Column(
                Modifier
                    .fillMaxSize()
                    .scrollable(
                        orientation = Orientation.Vertical,
                        state = rememberScrollState()
                    ),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                Text(text = "Seleciona a aula de Canvas")

                Button(onClick = { navController.navigate("lesson_1") }) {
                    Text(text = "Aula 1")
                }
                Button(onClick = { navController.navigate("lesson_2") }) {
                    Text(text = "Aula 2")
                }
                Button(onClick = { navController.navigate("lesson_3") }) {
                    Text(text = "Aula 3")
                }
                Button(onClick = { navController.navigate("lesson_4") }) {
                    Text(text = "Aula 4")
                }

            }


        }
    )
}