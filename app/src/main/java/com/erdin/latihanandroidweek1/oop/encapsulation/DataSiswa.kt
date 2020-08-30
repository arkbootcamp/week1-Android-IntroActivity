package com.erdin.latihanandroidweek1.oop.encapsulation

/**
 * Encapsulation Concept
 */

class DataSiswa {
    var nama: String? = null
    var nis: Int = 0
    var kelas: String? = null
    private var nilaiKu: Int = 0

    fun setNilai(nilai:Int) {
        nilaiKu = nilai
    }

    fun getNilai():Int {
        return nilaiKu
    }
}

fun main() {
    val biodata = DataSiswa()
    biodata.nama = "Muhammad Rizki"
    biodata.nis = 251117
    biodata.kelas = "7B"
    biodata.setNilai(100)

    println("Nama: ${biodata.nama}")
    println("Nis: ${biodata.nis}")
    println("Kelas: ${biodata.kelas}")
    println("Nilai: ${biodata.getNilai()}")

}