package br.com.vtvinicius.canvasprojectv1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import br.com.vtvinicius.canvasprojectv1.navigation.LessonsNavigationController
import br.com.vtvinicius.canvasprojectv1.projects.grafs.LineGraph
import br.com.vtvinicius.canvasprojectv1.projects.line_graph.Points
import br.com.vtvinicius.canvasprojectv1.ui.theme.ApplicationTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ApplicationTheme {

                LessonsNavigationController()
            }
        }
    }
}
