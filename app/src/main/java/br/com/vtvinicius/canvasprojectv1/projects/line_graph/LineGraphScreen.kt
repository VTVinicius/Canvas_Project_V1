package br.com.vtvinicius.canvasprojectv1.projects.line_graph

import androidx.compose.runtime.Composable
import br.com.vtvinicius.canvasprojectv1.projects.grafs.LineGraph

@Composable
fun LineGraphScreen() {

    val pointsList = mutableListOf<Points>()

    //Add 10 items to the Points list
    pointsList.add(Points(valueX = 100f, valueY = 300f))
    pointsList.add(Points(valueX = 150f, valueY = 100f))
    pointsList.add(Points(valueX = 200f, valueY = 300f))
    pointsList.add(Points(valueX = 250f, valueY = 100f))
    pointsList.add(Points(valueX = 300f, valueY = 300f))
    pointsList.add(Points(valueX = 350f, valueY = 100f))
    pointsList.add(Points(valueX = 400f, valueY = 300f))
    pointsList.add(Points(valueX = 450f, valueY = 100f))
    pointsList.add(Points(valueX = 500f, valueY =300f))
    pointsList.add(Points(valueX = 550f, valueY =100f))


    //oganize the list by the X value in ascending order
    pointsList.sortBy { it.valueX }


    LineGraph(pointsList = pointsList)
}