package br.com.vtvinicius.canvasprojectv1.lessons.lesson9

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathOperation
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp


@Composable
fun PathOperation() {

    val scrollState = rememberScrollState()
    Box(Modifier.verticalScroll(scrollState)) {

        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .height(2000.dp)
        ) {
            val squareWithoutOp1 = Path().apply {
                addRect(Rect(Offset(200f, 200f), Size(200f, 200f)))
            }
            val circle1 = Path().apply {
                addOval(Rect(Offset(200f, 200f), 100f))
            }
            val squareWithoutOp2 = Path().apply {
                addRect(Rect(Offset(200f, 600f), Size(200f, 200f)))
            }
            val circle2 = Path().apply {
                addOval(Rect(Offset(200f, 600f), 100f))
            }
            val squareWithoutOp3 = Path().apply {
                addRect(Rect(Offset(200f, 1000f), Size(200f, 200f)))
            }
            val circle3 = Path().apply {
                addOval(Rect(Offset(200f, 1000f), 100f))
            }
            val squareWithoutOp4 = Path().apply {
                addRect(Rect(Offset(200f, 1400f), Size(200f, 200f)))
            }
            val circle4 = Path().apply {
                addOval(Rect(Offset(200f, 1400f), 100f))
            }
            val pathWithOp1 = Path().apply {
                op(squareWithoutOp1, circle1, PathOperation.Difference)
            }
            val pathWithOp2 = Path().apply {
                op(squareWithoutOp2, circle2, PathOperation.ReverseDifference)
            }
            val pathWithOp3 = Path().apply {
                op(squareWithoutOp3, circle3, PathOperation.Union)
            }
            val pathWithOp4 = Path().apply {
                op(squareWithoutOp4, circle4, PathOperation.Xor)
            }
            drawPath(
                path = squareWithoutOp1,
                color = Color.Red,
                style = Stroke(width = 2.dp.toPx())
            )

            drawPath(
                path = circle1,
                color = Color.Blue,
                style = Stroke(width = 2.dp.toPx())
            )
            drawPath(
                path = squareWithoutOp2,
                color = Color.Red,
                style = Stroke(width = 2.dp.toPx())
            )

            drawPath(
                path = circle2,
                color = Color.Blue,
                style = Stroke(width = 2.dp.toPx())
            )
            drawPath(
                path = squareWithoutOp3,
                color = Color.Red,
                style = Stroke(width = 2.dp.toPx())
            )

            drawPath(
                path = circle3,
                color = Color.Blue,
                style = Stroke(width = 2.dp.toPx())
            )
            drawPath(
                path = squareWithoutOp4,
                color = Color.Red,
                style = Stroke(width = 2.dp.toPx())
            )

            drawPath(
                path = circle4,
                color = Color.Blue,
                style = Stroke(width = 2.dp.toPx())
            )
            drawPath(
                path = pathWithOp1,
                color = Color.Green,
            )
            drawPath(
                path = pathWithOp2,
                color = Color.Green,
            )
            drawPath(
                path = pathWithOp3,
                color = Color.Green,
            )
            drawPath(
                path = pathWithOp4,
                color = Color.Green,
            )
        }

    }
}
