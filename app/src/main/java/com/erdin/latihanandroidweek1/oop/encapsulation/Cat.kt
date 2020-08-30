package com.erdin.latihanandroidweek1.oop.encapsulation

/**
 * Encapsulation Concept
 */

class Cat {
    var mood: Int = 0
    private var hungry: Int = 0
    private var energy: Int = 0

    private fun meow() {
        println("Meooow!")
    }

    fun sleep() {
        energy++
        hungry++
        status()
    }

    fun play() {
        mood++
        energy--
        status()
    }

    fun feed() {
        hungry--
        mood++
        energy++
        meow()
        status()
    }

    private fun status() {
        println("Mood: $mood")
        println("Energy: $energy")
        println("Hungry: $hungry")
    }


}

fun main() {
    val playCat = Cat()
    playCat.play()
    playCat.feed()
}