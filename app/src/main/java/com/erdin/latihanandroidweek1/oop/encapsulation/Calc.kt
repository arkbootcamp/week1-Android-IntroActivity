package com.erdin.latihanandroidweek1.oop.encapsulation

/**
 * Encapsulation Concept
 */

class Calc {
    private var a = 0.0
    private var b = 0.0

    fun setA(a: Int) {
        this.a = a.toDouble()
    }

    fun getA(): Double {
        return a
    }

    fun setB(b:Int) {
        this.b = b.toDouble()
    }

    fun getB(): Double {
        return b
    }

    fun hasilKali():Double {
        return getA() * getB()
    }

    fun hasilBagi():Double {
        return getA() / getB()
    }

}

fun main() {
    val myCalc = Calc()
    print("Masukan nilai A: ")
    val a:Int = readLine()!!.toInt()
    myCalc.setA(a)

    print("Masukan nilai B: ")
    val b:Int = readLine()!!.toInt()
    myCalc.setB(b)

    println("Hasil Perkalian: ${myCalc.hasilKali()}")
    println("Hasil Pembagian: ${myCalc.hasilBagi()}")
}