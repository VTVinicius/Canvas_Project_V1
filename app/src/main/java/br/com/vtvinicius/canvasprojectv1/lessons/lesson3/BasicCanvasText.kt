package br.com.vtvinicius.canvasprojectv1.lessons.lesson3

import android.graphics.Color
import android.graphics.Paint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.unit.dp

@Composable
fun BasicCanvasText() {
    Canvas(modifier = Modifier.fillMaxSize().padding(20.dp)) {
        drawContext.canvas.nativeCanvas.apply {
            drawText(
                "This is my canvas text",
                this.clipBounds.left.toFloat(),
                this.clipBounds.exactCenterY(),
                        Paint ().apply {
                    color = Color.RED
                    textSize = 70f
                },
            )
        }
    }
}