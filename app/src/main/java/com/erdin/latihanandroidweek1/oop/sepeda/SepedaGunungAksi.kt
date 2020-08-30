package com.erdin.latihanandroidweek1.oop.sepeda

class SepedaGunungAksi {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            // Membuat Object
            val sepedaKu = SepedaGunung()

            // Pemanggilan method di object
            sepedaKu.ubahGir(6)
            sepedaKu.tambahKecepatan(20)
            sepedaKu.setSadel(4)
        }
    }
}



