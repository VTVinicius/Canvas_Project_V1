package br.com.vtvinicius.canvasprojectv1.lessons.lesson4

sealed class LineType {
    object Normal : LineType()
    object FiveStep : LineType()
    object TenStep : LineType()
}