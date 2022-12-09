package br.com.vtvinicius.canvasprojectv1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import br.com.vtvinicius.canvasprojectv1.projects.grafs.LineGraph
import br.com.vtvinicius.canvasprojectv1.projects.line_graph.Points
import br.com.vtvinicius.canvasprojectv1.ui.theme.ApplicationTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ApplicationTheme {

                //Add 10 items to the Points list
                val pointsList = mutableListOf<Points>()


                //random float between 100and 200


                pointsList.add(Points(valueX = 100f, valueY = 100f))
                pointsList.add(Points(valueX = 150f, valueY = 150f))
                pointsList.add(Points(valueX = 200f, valueY = 130f))
                pointsList.add(Points(valueX = 250f, valueY = 160f))
                pointsList.add(Points(valueX = 300f, valueY = 200f))
                pointsList.add(Points(valueX = 350f, valueY = 180f))
                pointsList.add(Points(valueX = 400f, valueY = 300f))
                pointsList.add(Points(valueX = 450f, valueY = 250f))
                pointsList.add(Points(valueX = 500f, valueY =270f))
                pointsList.add(Points(valueX = 550f, valueY =189f))
                pointsList.add(Points(valueX = 600f, valueY =100f))


                //oganize the list by the X value in ascending order
                pointsList.sortBy { it.valueX }


                LineGraph(pointsList = pointsList)
            }
        }
    }
}
