package br.com.vtvinicius.canvasprojectv1.lessons.lesson13

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GenderScreen() {

    var genero by remember {
        mutableStateOf("Feminino")
    }
    GenderPicker(onGenderSelected = {
        when (it) {
            Gender.Female -> genero = "Feminino"
            else -> genero = "Masculino"
        }
    }, modifier = Modifier.fillMaxSize())
    Row(
        Modifier
            .fillMaxSize()
            .padding(top = 64.dp),
        horizontalArrangement = Arrangement.Center
    ) {

        Text(text = "Selecionado: $genero", fontSize = 30.sp)

    }

}