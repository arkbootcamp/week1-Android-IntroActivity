package com.erdin.latihanandroidweek1.oop.pegawai

/**
 * Polymorphism Concept
 *
 * Override = Merubah isi si method
 * Overloading = Sama function tapi berbeda parameternya
 *
 */

open class Pegawai{
    var nama: String? = null
    var nip: Int = 0
    var alamat: String? = null

    fun addPegawai(nama:String?, nip: Int, alamat: String?) {
        this.nama = nama
        this.nip = nip
        this.alamat = alamat
    }

    open fun printPeg() {
        println("Nama: $nama")
        println("NIP: $nip")
        println("Alamat: $alamat")
    }
}