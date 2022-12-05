package br.com.vtvinicius.canvasprojectv1.lobby

import android.annotation.SuppressLint
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.vtvinicius.canvasprojectv1.ui.components.DefaultButton

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun LobbyScreen(navController: NavController) {


    BackHandler() {
        // FAZ O BOTÃO DE VOLTAR NÃO FECHAR O APP
    }
    Scaffold(
        content = {

            Column(
                Modifier
                    .fillMaxSize()
                    .scrollable(
                        orientation = Orientation.Vertical,
                        state = rememberScrollState()
                    ),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Spacer(modifier = Modifier.height(24.dp))

                Text(text = "Seleciona a aula de Canvas", fontSize = 24.sp)

                Spacer(modifier = Modifier.height(24.dp))

                DefaultButton(onClick = { navController.navigate("lesson_1") }, text = "Aula 1")

                Spacer(modifier = Modifier.height(24.dp))

                DefaultButton(onClick = { navController.navigate("lesson_2") }, text = "Aula 2")

                Spacer(modifier = Modifier.height(24.dp))

                DefaultButton(onClick = { navController.navigate("lesson_3") }, text = "Aula 3")

                Spacer(modifier = Modifier.height(24.dp))

                DefaultButton(onClick = { navController.navigate("lesson_4") }, text = "Aula 4")

                Spacer(modifier = Modifier.height(24.dp))

                DefaultButton(onClick = { navController.navigate("lesson_5") }, text = "Exercicio 1")

                Spacer(modifier = Modifier.height(24.dp))

                DefaultButton(onClick = { navController.navigate("lesson_6") }, text = "Aula 6")

                Spacer(modifier = Modifier.height(24.dp))

                DefaultButton(onClick = { navController.navigate("lesson_7") }, text = "Aula 7")

                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    )
}