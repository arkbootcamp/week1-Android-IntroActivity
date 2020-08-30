package com.erdin.latihanandroidweek1.oop.pegawai

class PegawaiAdministrasi:Pegawai() {
    var tempatBekerja:String? = null

    fun addPegawaiAdministrasi(nama:String, nip:Int, alamat:String, tempatBekerja:String) {
        super.addPegawai(nama, nip, alamat)
        this.tempatBekerja = tempatBekerja
    }

    // Override method PrintPeg
    override fun printPeg() {
        super.printPeg()
        println("Tempat Bekerja: ${this.getTempatBekerjas()}")
    }

    fun getTempatBekerjas(): String? {
        return this.tempatBekerja
    }

    fun cetakInfo() {
        this.printPeg()
    }

    // Overload method cetak info
    fun cetakInfo(keterangan:String) {
        this.printPeg()
        println("Keterangan : $keterangan")
    }

    fun cetakInfo(keterangan:String, jabatan:String) {
        this.printPeg()
        println("Keterangan : $keterangan")
        println("Jabatan : $jabatan")
    }

    fun cetakInfo(keterangan:String, jabatan:String, lamaBekerja:Int) {
        this.printPeg()
        println("Keterangan : $keterangan")
        println("Jabatan : $jabatan")
        println("Jabatan : $lamaBekerja")
    }

}

fun main() {
    val pegawaiKu = PegawaiAdministrasi()

    pegawaiKu.addPegawaiAdministrasi("Wahyu Kurniawan", 1234556, "Jakarta", "A01")
    println("-------")
    pegawaiKu.cetakInfo()
    println("-------")
    pegawaiKu.cetakInfo("NON PNS")
    println("-------")
    pegawaiKu.cetakInfo("PNS","Bendahara")
    println("-------")
    pegawaiKu.cetakInfo("PNS","Bendahara", 10)
    println("-------")
}