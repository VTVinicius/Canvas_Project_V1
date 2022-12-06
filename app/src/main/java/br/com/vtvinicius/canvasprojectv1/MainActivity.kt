package br.com.vtvinicius.canvasprojectv1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import br.com.vtvinicius.canvasprojectv1.lessons.lesson10.AnimatedArrow
import br.com.vtvinicius.canvasprojectv1.lessons.lesson10.AnimatedCircle
import br.com.vtvinicius.canvasprojectv1.lessons.lesson10.AnimatedPath
import br.com.vtvinicius.canvasprojectv1.lessons.lesson10.AnimatedScreen
import br.com.vtvinicius.canvasprojectv1.lessons.lesson9.PathOperation
import br.com.vtvinicius.canvasprojectv1.navigation.LessonsNavigationController
import br.com.vtvinicius.canvasprojectv1.ui.theme.ApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ApplicationTheme {
                AnimatedScreen()
            }
        }
    }
}
