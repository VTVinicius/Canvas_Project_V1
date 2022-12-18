package br.com.vtvinicius.canvasprojectv1.projects.snake

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import kotlin.math.roundToInt
import kotlin.random.Random

@Composable
fun SnakeGameScreen() {

    BallClicker()

}


@Composable
fun Snake() {


}


@Composable
fun BallClicker(
    radius: Float =
        60f,
    enabled: Boolean = false,
    ballColor: Color = Color.Red,
    onBallClick: () -> Unit = {},
) {


    var isGoingUp by remember {
        mutableStateOf(Directions().isGoingUp)
    }
    var isGoingDown by remember {
        mutableStateOf(Directions().isGoingDown)
    }
    var isGoingLeft by remember {
        mutableStateOf(Directions().isGoingLeft)
    }
    var isGoingRight by remember {
        mutableStateOf(Directions().isGoingRight)
    }

    var offset by remember {
        mutableStateOf(Offset(400f, 400f))
    }



    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
        var ballPosition by remember {
            mutableStateOf(
                snakeMovement(
                    offset = offset,
                    isGoingUp = isGoingUp,
                    isGoingDown = isGoingDown,
                    isGoingLeft = isGoingLeft,
                    isGoingRight = isGoingRight
                )
            )
        }

        Row(Modifier.fillMaxWidth()) {

            Button(onClick = {
                offset =   snakeMovement(
                    isGoingUp = true,
                    isGoingDown = false,
                    isGoingLeft = false,
                    isGoingRight = false,
                    offset = offset
                )
            }) {
                Text(text = "UP")
            }
            Button(onClick = {
                offset =  snakeMovement(
                    isGoingUp = false,
                    isGoingDown = true,
                    isGoingLeft = false,
                    isGoingRight = false,
                    offset = offset
                )
            }) {
                Text(text = "Down")
            }
            Button(onClick = {
                offset =   snakeMovement(
                    isGoingUp = false,
                    isGoingDown = false,
                    isGoingLeft = true,
                    isGoingRight = false,
                    offset = offset
                )
            }) {
                Text(text = "Left")
            }
            Button(onClick = {
                offset = snakeMovement(
                    isGoingUp = false,
                    isGoingDown = false,
                    isGoingLeft = false,
                    isGoingRight = true,
                    offset = offset
                )
            }) {
                Text(text = "Right")
            }
        }


        LaunchedEffect(key1 = isGoingDown) {
            offset = snakeMovement(
                isGoingUp = isGoingUp,
                isGoingDown = isGoingDown,
                isGoingLeft = isGoingLeft,
                isGoingRight = isGoingRight,
                offset = offset
            )
        }

        LaunchedEffect(key1 = isGoingRight) {
            offset = snakeMovement(
                isGoingUp = isGoingUp,
                isGoingDown = isGoingDown,
                isGoingLeft = isGoingLeft,
                isGoingRight = isGoingRight,
                offset = offset
            )
        }

        LaunchedEffect(key1 = isGoingLeft) {
            offset = snakeMovement(
                isGoingUp = isGoingUp,
                isGoingDown = isGoingDown,
                isGoingLeft = isGoingLeft,
                isGoingRight = isGoingRight,
                offset = offset
            )
        }
        LaunchedEffect(key1 = isGoingUp) {
            offset = snakeMovement(
                isGoingUp = isGoingUp,
                isGoingDown = isGoingDown,
                isGoingLeft = isGoingLeft,
                isGoingRight = isGoingRight,
                offset = offset
            )
        }

        Canvas(
            modifier = Modifier
                .fillMaxSize()
        ) {
            drawCircle(
                color = ballColor,
                radius = radius,
                center = offset

            )
        }
    }
}


private fun randomOffset(radius: Float, width: Int, height: Int): Offset {
    return Offset(
        x = Random.nextInt(radius.roundToInt(), width - radius.roundToInt()).toFloat(),
        y = Random.nextInt(radius.roundToInt(), height - radius.roundToInt()).toFloat()
    )
}


private fun snakeMovement(
    isGoingUp: Boolean,
    isGoingDown: Boolean,
    isGoingRight: Boolean,
    isGoingLeft: Boolean,
    offset: Offset,
): Offset {

    return when {
        isGoingUp -> {
            return Offset(
                x = offset.x,
                y = offset.y - 10f
            )
        }
        isGoingDown -> {
            return Offset(
                x = offset.x,
                y = offset.y + 10f
            )
        }
        isGoingRight -> {
            return Offset(
                x = offset.x + 10f,
                y = offset.y
            )
        }
        isGoingLeft -> {
            return Offset(
                x = offset.x - 10f,
                y = offset.y
            )
        }
        else -> {
            return offset
        }
    }
}

