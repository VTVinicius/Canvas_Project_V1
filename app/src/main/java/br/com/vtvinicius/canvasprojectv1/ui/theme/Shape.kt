package br.com.vtvinicius.canvasprojectv1.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.dp
data class AppDimensions(

    val small: RoundedCornerShape = RoundedCornerShape(4.dp),
    val medium: RoundedCornerShape = RoundedCornerShape(4.dp),
    val large: RoundedCornerShape = RoundedCornerShape(0.dp),
    val defaultSize: RoundedCornerShape = RoundedCornerShape(10.dp),
    val rounded: RoundedCornerShape = RoundedCornerShape(110.dp)
)

internal val LocalDimensions = staticCompositionLocalOf { AppDimensions() }