package com.erdin.latihanandroidweek1.kotlin

val sum = {number1:Int, number2: Int ->
    number1+number2
}

fun main() {
    println("list of numbers")
    val listOfNumbers = listOf(10, 15, 22, 34, 80)

    // Normal Loop
//    for (item in listOfNumbers) {
//        println(item)
//    }

    listOfNumbers.forEach { angka ->
        println(angka)
    }

    println("End List number")

    val addNumbers = sum(5, 10)
    println("Result : $addNumbers")



}