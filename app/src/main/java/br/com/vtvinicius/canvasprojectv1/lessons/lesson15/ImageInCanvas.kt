package br.com.vtvinicius.canvasprojectv1.lessons.lesson15

import android.widget.Space
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import br.com.vtvinicius.canvasprojectv1.R

@Composable
fun ImageInCanvas() {
    val kermit = ImageBitmap.imageResource(id = R.drawable.kermit)

    Column(Modifier.fillMaxSize()
        .verticalScroll(rememberScrollState())) {

        Canvas(modifier = Modifier.height(300.dp)) {

            drawImage(
                image = kermit,
                dstOffset = IntOffset(100, 100),
                dstSize = IntSize(
                    (400 * (kermit.width.toFloat() / kermit.height)).toInt(),
                    400
                ),
            )
            drawCircle(
                color = Color.Red,
                radius = 100f,
                center = Offset(300f, 300f),
                blendMode = BlendMode.Color
            )
        }
        
        Canvas(modifier = Modifier.height(300.dp)) {

            drawImage(
                image = kermit,
                dstOffset = IntOffset(100, 100),
                dstSize = IntSize(
                    (400 * (kermit.width.toFloat() / kermit.height)).toInt(),
                    400
                ),
            )
            drawCircle(
                color = Color.Black,
                radius = 100f,
                center = Offset(300f, 300f),
                blendMode = BlendMode.Color
            )
        }

        Canvas(modifier = Modifier.height(300.dp)) {

            drawImage(
                image = kermit,
                dstOffset = IntOffset(100, 100),
                dstSize = IntSize(
                    (400 * (kermit.width.toFloat() / kermit.height)).toInt(),
                    400
                ),
            )
            drawCircle(
                color = Color.Red,
                radius = 100f,
                center = Offset(300f, 300f),
                blendMode = BlendMode.Exclusion
            )
        }
        Canvas(modifier = Modifier.height(300.dp)) {

            drawImage(
                image = kermit,
                dstOffset = IntOffset(100, 100),
                dstSize = IntSize(
                    (400 * (kermit.width.toFloat() / kermit.height)).toInt(),
                    400
                ),
            )
            drawCircle(
                color = Color.Red,
                radius = 100f,
                center = Offset(300f, 300f),
                blendMode = BlendMode.Overlay
            )
        }
        Canvas(modifier = Modifier.height(300.dp)) {

            drawImage(
                image = kermit,
                dstOffset = IntOffset(100, 100),
                dstSize = IntSize(
                    (400 * (kermit.width.toFloat() / kermit.height)).toInt(),
                    400
                ),
            )
            drawCircle(
                color = Color.Red,
                radius = 100f,
                center = Offset(300f, 300f),
                blendMode = BlendMode.Modulate
            )
        }
    }
}