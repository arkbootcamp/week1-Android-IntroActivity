package com.erdin.latihanandroidweek1.kotlin

private fun discount(qty: Int, price: Int) {
    val total = qty * price
    var potongan = 0
    if (total >= 60000) {
        potongan = total * 35 / 100
        if (potongan > 50000) {
            potongan = 50000
        } else {
            potongan
        }
    } else {
        potongan = 0
    }
    val subtotal = total - potongan
    println("Total: $total")
    println("Potongan: $potongan")
    println("Sub Total: $subtotal")
}

fun main(){
    discount(4, 60000)
}