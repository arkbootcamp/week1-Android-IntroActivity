package com.erdin.latihanandroidweek1.kotlin

fun main() {

    println("==Increment==")
    for (i in 0..20 step 2) {
        println("Angka: $i")
    }

    println("==Decrement==")
    for (i in 20 downTo 1 step 3) {
        println("Angka: $i")
    }

    for (number in 1..10) {
        if (number == 5) {
            continue
        }
        println(number)
    }

    for (number in 1..10) {
        if (number == 7) {
            break
        }
        println(number)
    }


    println("END")

}