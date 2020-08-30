package com.erdin.latihanandroidweek1.oop.sepeda

/**
 * Inheritance Concept
 */

open class Sepada {
    // Deklarasi attribut
    var gir = 0
    var kecepatan = 0

    // method
    fun ubahGir(pertambahanGir: Int) {
        gir += pertambahanGir
        println("Gir: $gir")
    }

    fun tambahKecepatan(pertambahanKecepatan:Int) {
        kecepatan += pertambahanKecepatan
        println("Kecepatan: $kecepatan")
    }
}