package br.com.vtvinicius.canvasprojectv1.lessons.lesson6

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay

@Composable
fun ClockScreenResolved() {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        val milliseconds = remember {
            System.currentTimeMillis()
        }
        var seconds by remember {
            mutableStateOf((milliseconds / 1000f) % 60f)
        }
        var minutes by remember {
            mutableStateOf(((milliseconds / 1000f) / 60) % 60f)
        }
        var hours by remember {
            mutableStateOf((milliseconds / 1000f) / 3600f + 2f)
        }
        LaunchedEffect(key1 = seconds) {
            delay(1000L)
            minutes += 1f / 60f
            hours += 1f / (60f * 12f)
            seconds += 1f
        }
        Clock(
            seconds = seconds,
            minutes = minutes,
            hours = hours
        )
    }
}