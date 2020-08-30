package com.erdin.latihanandroidweek1.oop.sepeda

class SepedaTandomAksi{
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val sepedaTandomKu = SepadaTandom()

            sepedaTandomKu.ubahGir(8)
            sepedaTandomKu.tambahKecepatan(40)
            sepedaTandomKu.addSadel(3)

        }
    }
}