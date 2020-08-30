package com.erdin.latihanandroidweek1.oop.creditcard

/**
 * Abstraction Concept
 */

abstract class CreditCard {
    fun CreditId():String { return "649282625" }

    abstract fun newCreditCard()
}

class UserInfo:CreditCard(){
    fun getInfo():String {
        return CreditId()
    }

    override fun newCreditCard() {
        println("Credit Card Created!")
    }

}

fun main() {
    val credit = UserInfo()
    println(credit.getInfo())
    credit.newCreditCard()
}