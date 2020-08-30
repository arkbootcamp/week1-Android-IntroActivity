package com.erdin.latihanandroidweek1.kotlin

fun main() {
    val a = 80
    val b = 22

    if (a > b) {
        println("Sum: ${a+b}")
    }

    print("Input your grade: ")
    val grade = readLine()!!.toInt()

    if (grade >= a) {
        println("A")
    } else {
        println("Gagal")
    }

}