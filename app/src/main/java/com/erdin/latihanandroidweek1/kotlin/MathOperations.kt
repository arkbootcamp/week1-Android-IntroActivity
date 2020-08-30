package com.erdin.latihanandroidweek1.kotlin

fun main() {
    println("Simple Calculator")

    print("Input Number 1 : ")
    val number1 = readLine()!!.toInt()
    print("Input Number 2 : ")
    val number2 = readLine()!!.toInt()

    var tambah = number1 + number2
    println("Tambah: $tambah")

    var pengurangan = number1 - number2
    println("Pengurangan: $pengurangan")

    val perkalian = number1 * number2
    println("Perkalian: $perkalian")

    val pembagian = number1 / number2
    println("Pembagian: $pembagian")

    tambah += 40
    pengurangan -= 20

    println("Tambah: $tambah")
    println("Kurang: $pengurangan")

}