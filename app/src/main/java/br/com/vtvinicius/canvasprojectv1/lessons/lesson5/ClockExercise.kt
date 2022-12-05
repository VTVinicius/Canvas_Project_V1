package br.com.vtvinicius.canvasprojectv1.lessons.lesson5

import android.graphics.Color
import android.graphics.Paint
import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.core.graphics.withRotation
import br.com.vtvinicius.canvasprojectv1.lessons.lesson4.LineType
import br.com.vtvinicius.canvasprojectv1.lessons.lesson4.ScaleStyle2
import kotlinx.coroutines.delay
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun ClockExercise(
    seconds: Float = 0f,
    minutes: Float = 0f,
    hours: Float = 0f,
    modifier: Modifier = Modifier,
    style: ScaleStyle2 = ScaleStyle2(),
) {

    var circleCenter by remember {
        mutableStateOf(Offset.Zero)
    }

    var center by remember {
        mutableStateOf(Offset.Zero)
    }

    val scaleWidth: Dp = 100.dp
    val radius = 50.dp


    var angle by remember {
        mutableStateOf(0f)
    }
    var angle1 by remember {
        mutableStateOf(30f)
    }
    var angle2 by remember {
        mutableStateOf(90f)
    }
    var angle3 by remember {
        mutableStateOf(120f)
    }



    LaunchedEffect(key1 = angle1) {
        delay(1000L)
        angle1 += 6f
    }

    LaunchedEffect(key1 = angle3) {
        delay(3000L)
        angle3 += 6f
    }

    LaunchedEffect(key1 = angle2) {
        delay(5000L)
        angle2 += 6f
    }



    Canvas(modifier = modifier) {

        center = this.center
        circleCenter = Offset(
            center.x,
            scaleWidth.toPx() / 2f + radius.toPx()
        )

        val outerRadius = radius.toPx() + scaleWidth.toPx() / 2f

        drawContext.canvas.nativeCanvas.apply {
            drawCircle(
                circleCenter.x,
                circleCenter.y,
                radius.toPx(),
                Paint().apply {
                    strokeWidth = scaleWidth.toPx()
                    color = Color.WHITE
                    setStyle(Paint.Style.FILL_AND_STROKE)
                    setShadowLayer(
                        50f,
                        0f,
                        0f,
                        Color.argb(50, 0, 0, 0)
                    )
                }
            )
        }

        for (i in 0..360) {
            val angleInRad = (i - 0 + angle - 90) * ((PI / 180f).toFloat())
            val lineType = when {
                i % 30 == 0 -> LineType.FiveStep
                i % 6 == 0 -> LineType.Normal
                else -> {
                    LineType.TenStep
                }
            }
            val lineLength = when (lineType) {
                LineType.Normal -> style.normalLineLength.toPx()
                LineType.FiveStep -> style.fiveStepLineLength.toPx()
                else -> {
                    style.tenStepLineLength.toPx()
                }
            }
            val lineColor = when (lineType) {
                LineType.Normal -> style.normalLineColor
                LineType.FiveStep -> style.fiveStepLineColor
                else -> {
                    style.tenStepLineColor
                }
            }
            val lineStart = Offset(
                x = (outerRadius - lineLength) * cos(angleInRad) + circleCenter.x,
                y = (outerRadius - lineLength) * sin(angleInRad) + circleCenter.y
            )
            val lineEnd = Offset(
                x = outerRadius * cos(angleInRad) + circleCenter.x,
                y = outerRadius * sin(angleInRad) + circleCenter.y
            )

            drawLine(
                color = lineColor,
                start = lineStart,
                end = lineEnd,
                strokeWidth = 1.dp.toPx()
            )
        }


        drawContext.canvas.nativeCanvas.withRotation(
            degrees = seconds * (360f / 60f),
            circleCenter.x,
            circleCenter.y
        ) {
            drawLine(
                color = style.scaleIndicator1Color,
                start = Offset(
                    x = circleCenter.x,
                    y = circleCenter.y
                ),
                end = Offset(
                    x = circleCenter.x,
                    y = circleCenter.y - (radius.toPx() + 20.dp.toPx())
                ),
                strokeWidth = 1.dp.toPx()
            )
        }
        drawContext.canvas.nativeCanvas.withRotation(
            degrees = hours * (360f / 12f),
            circleCenter.x,
            circleCenter.y
        ) {
            drawLine(
                color = style.scaleIndicator2Color,
                start = Offset(
                    x = circleCenter.x,
                    y = circleCenter.y
                ),
                end = Offset(
                    x = circleCenter.x,
                    y = circleCenter.y - radius.toPx()
                ),
                strokeWidth = 1.dp.toPx()
            )
        }
        drawContext.canvas.nativeCanvas.withRotation(
            degrees = minutes * (360f / 60f),
            circleCenter.x,
            circleCenter.y
        ) {
            drawLine(
                color = style.scaleIndicator3Color,
                start = Offset(
                    x = circleCenter.x,
                    y = circleCenter.y
                ),
                end = Offset(
                    x = circleCenter.x,
                    y = circleCenter.y - (radius.toPx() + 20.dp.toPx())
                ),
                strokeWidth = 1.dp.toPx()
            )
        }

    }
}
