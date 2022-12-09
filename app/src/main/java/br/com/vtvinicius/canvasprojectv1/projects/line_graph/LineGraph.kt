package br.com.vtvinicius.canvasprojectv1.projects.grafs

import android.graphics.Paint
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.asAndroidPath
import androidx.compose.ui.graphics.asComposePath
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.vtvinicius.canvasprojectv1.projects.line_graph.Points
import kotlin.math.PI
import kotlin.math.atan2

@Composable
fun LineGraph(
    modifier: Modifier = Modifier,
    pointsList: MutableList<Points> = mutableListOf(),
) {
    val pathPortionX = remember {
        Animatable(initialValue = 0f)
    }
    val pathPortionY = remember {
        Animatable(initialValue = 0f)
    }
    val lazyState = rememberLazyListState()

    LaunchedEffect(key1 = true) {
        pathPortionX.animateTo(
            targetValue = 1f,
            animationSpec = tween(
                durationMillis = 3000
            )
        )
    }
    LaunchedEffect(key1 = true) {
        pathPortionY.animateTo(
            targetValue = 1f,
            animationSpec = tween(
                durationMillis = 3000
            )
        )
    }


    //drown line every 100dp
    LazyColumn(
        state = lazyState, modifier = Modifier
            .fillMaxSize()
            .padding(top = 100.dp)
    ) {

        items(pointsList.size) {
            Lines(y = pointsList[it].valueY)
        }

    }

    val leftSide = 70.dp


    Canvas(modifier = Modifier.fillMaxSize()) {


        val pathX = Path().apply {
            moveTo(leftSide.toPx(), center.y.dp.toPx())
            lineTo((center.x + center.x - 20), center.y.dp.toPx())
        }
        val outPathX = android.graphics.Path()
        val posX = FloatArray(2)
        val tanX = FloatArray(2)
        android.graphics.PathMeasure().apply {
            setPath(pathX.asAndroidPath(), false)
            getSegment(0f, pathPortionX.value * length, outPathX, true)
            getPosTan(pathPortionX.value * length, posX, tanX)
        }



        drawPath(
            path = outPathX.asComposePath(),
            color = Color.Red,
            style = Stroke(width = 5.dp.toPx(), cap = StrokeCap.Round)
        )


        val xX = posX[0]
        val yX = posX[1]
        val degreesX = -atan2(tanX[0], tanX[1]) * (180f / PI.toFloat()) - 180f
        rotate(degrees = degreesX, pivot = Offset(xX, yX)) {
            drawPath(
                path = Path().apply {
                    moveTo(xX, yX - 15f)
                    lineTo(xX - 15f, yX + 30f)
                    lineTo(xX + 15f, yX + 30f)
                    close()
                },
                color = Color.Red
            )
        }
    }

    Canvas(modifier = Modifier.fillMaxSize()) {

        val pathY = Path().apply {
            moveTo(leftSide.toPx(), center.y.dp.toPx())
            lineTo(leftSide.toPx(), size.height - size.height + 20)
        }
        val outPathY = android.graphics.Path()
        val posY = FloatArray(2)
        val tanY = FloatArray(2)
        android.graphics.PathMeasure().apply {
            setPath(pathY.asAndroidPath(), false)
            getSegment(0f, pathPortionY.value * length, outPathY, true)
            getPosTan(pathPortionY.value * length, posY, tanY)
        }


        drawPath(
            path = outPathY.asComposePath(),
            color = Color.Red,
            style = Stroke(width = 5.dp.toPx(), cap = StrokeCap.Round)
        )

        val xY = posY[0]
        val yY = posY[1]
        val degrees = -atan2(tanY[0], tanY[1]) * (180f / PI.toFloat()) - 180f
        rotate(degrees = degrees, pivot = Offset(xY, yY)) {
            drawPath(
                path = Path().apply {
                    moveTo(xY, yY - 15f)
                    lineTo(xY - 15f, yY + 30f)
                    lineTo(xY + 15f, yY + 30f)
                    close()
                },
                color = Color.Red
            )
        }

    }


    Canvas(modifier = Modifier.fillMaxSize()) {


        drawPath(
            path = Path().apply {
                moveTo(leftSide.toPx(), pointsList.first().valueY.dp.toPx())
                for (i in 0..pointsList.size - 1) {
                    val isLastItem = i == pointsList.size - 1
                    lineTo(
                        pointsList[i].valueX.dp.toPx(),
                        pointsList[if (isLastItem) i else i + 1].valueY.dp.toPx()
                    )
                }
            },
            color = Color.Red,
            style = Stroke(width = 5.dp.toPx(), cap = StrokeCap.Round)
        )

        for (i in 0..pointsList.size - 1) {
            drawContext.canvas.nativeCanvas.apply {
                drawText(
                    "${pointsList[i].valueY}",
                    10.dp.toPx(),
                    pointsList[i].valueY.dp.toPx() - 5.dp.toPx(),
                    Paint().apply {
                        color = android.graphics.Color.RED
                        textSize = 14.dp.toPx()
                    },
                )

                if( (40 * (i+1) < center.y)) {
                    drawLine(
                        color = Color.Green,
                        start = Offset((leftSide - 10.dp).toPx(), (40 * (i + 1)).dp.toPx()),
                        end = Offset((leftSide + 10.dp).toPx(), (40 * (i + 1)).dp.toPx()),
                        strokeWidth = 5f
                    )
                }
            }
        }
    }
}

@Composable
fun Lines(y: Float) {

    Canvas(modifier = Modifier.fillMaxSize()) {


    }

}

@Preview
@Composable
fun LineGraphPreview() {
    LineGraph()
}