package br.com.vtvinicius.canvasprojectv1.lobby

import android.annotation.SuppressLint
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.vtvinicius.canvasprojectv1.lessons.lesson12.LobbyBackground
import br.com.vtvinicius.canvasprojectv1.ui.components.DefaultButton

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun LobbyScreen(navController: NavController) {

    BackHandler() {
        // FAZ O BOTÃO DE VOLTAR NÃO FECHAR O APP
    }

    val scrollState = rememberScrollState()
    Scaffold(
        content = {
            Column(

                Modifier
                    .fillMaxSize()
                    .verticalScroll(
                        scrollState
                    ),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                LobbyBackground()

                Spacer(modifier = Modifier.height(24.dp))

                Text(text = "Seleciona a aula de Canvas", fontSize = 24.sp)

                Spacer(modifier = Modifier.height(24.dp))

                DefaultButton(onClick = { navController.navigate("lesson_1") }, text = "Aula 1")

                Spacer(modifier = Modifier.height(24.dp))

                DefaultButton(onClick = { navController.navigate("lesson_2") }, text = "Aula 2")

                Spacer(modifier = Modifier.height(24.dp))

                DefaultButton(onClick = { navController.navigate("lesson_3") }, text = "Aula 3")

                Spacer(modifier = Modifier.height(24.dp))

                DefaultButton(onClick = { navController.navigate("lesson_4") }, text = "Aula 4", colors = Color.LightGray)

                Spacer(modifier = Modifier.height(24.dp))

                DefaultButton(
                    onClick = { navController.navigate("lesson_5") },
                    text = "Exercicio 1"
                )

                Spacer(modifier = Modifier.height(24.dp))

                DefaultButton(onClick = { navController.navigate("lesson_6") }, text = "Aula 6", colors = Color.LightGray)

                Spacer(modifier = Modifier.height(24.dp))

                DefaultButton(onClick = { navController.navigate("lesson_7") }, text = "Aula 7")

                Spacer(modifier = Modifier.height(24.dp))

                DefaultButton(onClick = { navController.navigate("lesson_8") }, text = "Aula 8")

                Spacer(modifier = Modifier.height(24.dp))

                DefaultButton(onClick = { navController.navigate("lesson_8_1") }, text = "Aula 8.1")

                Spacer(modifier = Modifier.height(24.dp))

                DefaultButton(onClick = { navController.navigate("lesson_9") }, text = "Aula 9")

                Spacer(modifier = Modifier.height(24.dp))

                DefaultButton(onClick = { navController.navigate("lesson_10") }, text = "Aula 10")

                Spacer(modifier = Modifier.height(24.dp))

                DefaultButton(onClick = { navController.navigate("lesson_11") }, text = "Aula 11")

                Spacer(modifier = Modifier.height(24.dp))

                DefaultButton(onClick = { navController.navigate("lesson_12") }, text = "Aula 12", colors = Color.LightGray)

                Spacer(modifier = Modifier.height(24.dp))

                DefaultButton(onClick = { navController.navigate("lesson_13") }, text = "Aula 13", colors = Color.LightGray)

                Spacer(modifier = Modifier.height(24.dp))

                DefaultButton(onClick = { navController.navigate("lesson_14") }, text = "Aula 14", colors = Color.LightGray)

                Spacer(modifier = Modifier.height(24.dp))

                DefaultButton(onClick = { navController.navigate("lesson_15") }, text = "Aula 15")

                Spacer(modifier = Modifier.height(24.dp))

                DefaultButton(onClick = { navController.navigate("lesson_16") }, text = "Aula 16", colors = Color.LightGray)

                Spacer(modifier = Modifier.height(24.dp))

                DefaultButton(onClick = { navController.navigate("pratica_1") }, text = "Pratica 01", colors = Color.Gray)

                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    )
}