package com.erdin.latihanandroidweek1.kotlin

fun main() {
    // print
    println("Erdin Suharyadi")
    print("Arkademy")
    println(" Class Android 1")

    // variable immutable
    val name = "Erdin Suharyadi"
    val age = 30
    val domain = "arkademy.com"

    println("Nama saya $name, umur saya $age, domain saya $domain")
    println("Nama saya " + name + ", umur saya " + age)

    // variable mutable
    var ipk = 4.0
    ipk = 3.2
    println("IPK: $ipk")

    var city: String = "String"
    val noHP: Int = 123

    // Komentar satu baris

    /*
    Komentar beberapa baris
    baris 1
    baris 2
     */

    /*
    Penulisan nama variabel

    Camel Case -> akuDisini
    Snack Case -> aku_disini
    Pascal Case ->  AkuDisini

     */

    val tinggiBadan: Int = 1
    var beratBadan: Int? = null

    print("Berat Badan: ${beratBadan?.toDouble() ?: "100"}")






}