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
import kotlinx.coroutines.delay

@Composable
fun SnakeGameScreen() {

    BallClicker()

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


        val maxHeigth by remember {
            mutableStateOf(constraints.maxHeight.toFloat())
        }

        val maxWidth by remember {
            mutableStateOf(constraints.maxWidth.toFloat())
        }


        Row(Modifier.fillMaxWidth()) {

            Button(onClick = {
                isGoingUp = true
                isGoingDown = false
                isGoingLeft = false
                isGoingRight = false
                offset = snakeMovement(
                    isGoingUp = isGoingUp,
                    isGoingDown = isGoingDown,
                    isGoingLeft = isGoingLeft,
                    isGoingRight = isGoingRight,
                    offset = offset,
                    maxHeigth = maxHeigth,
                    maxWidth = maxWidth
                )
            }) {
                Text(text = "UP")
            }
            Button(onClick = {
                isGoingUp = false
                isGoingDown = true
                isGoingLeft = false
                isGoingRight = false
                offset = snakeMovement(
                    isGoingUp = isGoingUp,
                    isGoingDown = isGoingDown,
                    isGoingLeft = isGoingLeft,
                    isGoingRight = isGoingRight,
                    offset = offset,
                    maxHeigth = maxHeigth,
                    maxWidth = maxWidth
                )
            }) {
                Text(text = "Down")
            }
            Button(onClick = {
                isGoingUp = false
                isGoingDown = false
                isGoingLeft = true
                isGoingRight = false
                offset = snakeMovement(
                    isGoingUp = isGoingUp,
                    isGoingDown = isGoingDown,
                    isGoingLeft = isGoingLeft,
                    isGoingRight = isGoingRight,
                    offset = offset,
                            maxHeigth = maxHeigth,
                    maxWidth = maxWidth
                )

            }) {
                Text(text = "Left")
            }
            Button(onClick = {
                isGoingUp = false
                isGoingDown = false
                isGoingLeft = false
                isGoingRight = true
                offset = snakeMovement(
                    isGoingUp = isGoingUp,
                    isGoingDown = isGoingDown,
                    isGoingLeft = isGoingLeft,
                    isGoingRight = isGoingRight,
                    offset = offset,
                    maxHeigth = maxHeigth,
                    maxWidth = maxWidth
                )

            }) {
                Text(text = "Right")
            }
        }


        LaunchedEffect(key1 = offset, key2 = isGoingDown) {
            delay(100)
            offset = snakeMovement(
                isGoingUp = isGoingUp,
                isGoingDown = isGoingDown,
                isGoingLeft = isGoingLeft,
                isGoingRight = isGoingRight,
                offset = offset,
                maxHeigth = maxHeigth,
                maxWidth = maxWidth
            )
        }

        LaunchedEffect(key1 = offset, key2 = isGoingDown) {
            delay(100)
            offset = snakeMovement(
                isGoingUp = isGoingUp,
                isGoingDown = isGoingDown,
                isGoingLeft = isGoingLeft,
                isGoingRight = isGoingRight,
                offset = offset,
                maxHeigth = maxHeigth,
                maxWidth = maxWidth
            )
        }

        LaunchedEffect(key1 = offset, key2 = isGoingDown) {
            delay(100)
            offset = snakeMovement(
                isGoingUp = isGoingUp,
                isGoingDown = isGoingDown,
                isGoingLeft = isGoingLeft,
                isGoingRight = isGoingRight,
                offset = offset,
                maxHeigth = maxHeigth,
                maxWidth = maxWidth
            )
        }
        LaunchedEffect(key1 = offset, key2 = isGoingRight) {
            delay(100)
            offset = snakeMovement(
                isGoingUp = isGoingUp,
                isGoingDown = isGoingDown,
                isGoingLeft = isGoingLeft,
                isGoingRight = isGoingRight,
                offset = offset,
                maxHeigth = maxHeigth,
                maxWidth = maxWidth
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


private fun snakeMovement(
    isGoingUp: Boolean,
    isGoingDown: Boolean,
    isGoingRight: Boolean,
    isGoingLeft: Boolean,
    offset: Offset,
    maxHeigth: Float,
    maxWidth: Float,
): Offset {

    return when {
        isGoingUp -> {
            return if (offset.y <= 0f) {
                Offset(
                    x = offset.x,
                    y = offset.y
                )
            } else {
                Offset(
                    x = offset.x,
                    y = offset.y - 5f
                )
            }
        }
        isGoingDown -> {
            return if (offset.y >= maxHeigth) {
                Offset(
                    x = offset.x,
                    y = offset.y
                )
            } else {
                Offset(
                    x = offset.x,
                    y = offset.y + 5f
                )
            }
        }
        isGoingRight -> {
            return if (offset.x >= maxWidth) {
                Offset(
                    x = offset.x,
                    y = offset.y
                )
            } else {
                Offset(
                    x = offset.x + 5f,
                    y = offset.y
                )
            }
        }
        isGoingLeft -> {
            return if (offset.x <= 0f) {
                Offset(
                    x = offset.x,
                    y = offset.y
                )
            } else {
                Offset(
                    x = offset.x - 5f,
                    y = offset.y
                )
            }
        }
            else -> {
                return offset
            }
        }
    }

