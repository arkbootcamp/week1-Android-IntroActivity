package com.erdin.latihanandroidweek1.kotlin

/*
    Mutable -> Read and Write, or add more
    Immutable -> Read Only
 */

fun main() {

    println("==Immutable==")
    val listImmutable = listOf("Anggur","Pepaya")
//    listImmutable[1] = "Jeruk"
    for (fruit in listImmutable) {
        println(fruit)
    }

    println("==Mutable==")
    var listMutable = mutableListOf("Burger", "Pizza", "Sosis")
    listMutable[2] = "Karedok"
    for (food in listMutable) {
        println(food)
    }
}