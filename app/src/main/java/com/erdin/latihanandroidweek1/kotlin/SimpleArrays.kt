package com.erdin.latihanandroidweek1.kotlin

fun main() {
    println("Pets App")
    print("Enter number of Pets: ")
    val maxSize = readLine()!!.toInt()

    var listOfPets:Array<String> = Array(maxSize){""}
    for (i in 0 until maxSize){
        print("Enter pet name $i: ")
        listOfPets[i] = readLine()!!.toString()
    }

    println("Your Pets")
    for (i in 0 until maxSize) {
        println("Pet $i: ${listOfPets[i]}")
    }

}