package com.erdin.latihanandroidweek1.kotlin

fun addNumbers(x:Double = 0.0, y:Double = 0.0):Double {
    return x+y
}

fun main() {
    println("Start Function")

    var returnAdd = addNumbers(2.0,4.0)
    println("Return Add: $returnAdd")

    returnAdd = addNumbers(6.0,4.0)
    println("Return Add: $returnAdd")

    returnAdd = addNumbers(3.0)
    println("Return Add: $returnAdd")
}