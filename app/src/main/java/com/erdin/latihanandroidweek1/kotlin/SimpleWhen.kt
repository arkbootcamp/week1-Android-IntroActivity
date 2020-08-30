package com.erdin.latihanandroidweek1.kotlin

fun main() {
    print("Pilih menu: ")
    val foodId = readLine()!!.toInt()

    when (foodId) {
        1 -> {
            println("1. Ayam Goreng")
            println("2. Nasi")
            println("3. Teh Manis")
        }

        2 -> {
            println("1. Lele Goreng")
            println("2. Nasi")
            println("3. Teh Manis")
        }

        3 -> {
            println("1. Bebek Goreng")
            println("2. Nasi")
            println("3. ES Teh Manis")
        }

        else -> {
            println("Menu tidak tersedia")
        }
    }
}