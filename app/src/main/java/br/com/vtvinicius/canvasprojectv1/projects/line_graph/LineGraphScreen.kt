package br.com.vtvinicius.canvasprojectv1.projects.line_graph

import androidx.compose.runtime.Composable

@Composable
fun LineGraphScreen() {

    val pointsList = mutableListOf<Points>()

    //Add 10 items to the Points list
    pointsList.add(Points( valueY = 300f))
    pointsList.add(Points( valueY = 100f))
    pointsList.add(Points( valueY = 300f))
    pointsList.add(Points(valueY = 100f))
    pointsList.add(Points( valueY = 300f))
    pointsList.add(Points( valueY = 100f))
    pointsList.add(Points( valueY = 300f))
    pointsList.add(Points( valueY = 100f))
    pointsList.add(Points( valueY =300f))
    pointsList.add(Points( valueY =100f))
    pointsList.add(Points( valueY =300f))
    pointsList.add(Points( valueY =100f))
    pointsList.add(Points( valueY =300f))
    pointsList.add(Points( valueY =100f))
    pointsList.add(Points( valueY =300f))
    pointsList.add(Points( valueY =100f))


    //oganize the list by the X value in ascending order



    LineGraph(pointsList = pointsList)
}