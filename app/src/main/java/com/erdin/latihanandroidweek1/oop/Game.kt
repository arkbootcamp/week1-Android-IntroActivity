package com.erdin.latihanandroidweek1.oop

/**
  *  Simple OOP - Attribute & Method
 */

class Player {

    //Definisi Atribut
    var name: String? = null
    var speed = 0
    var healthPoin = 0

    // Definisi Method
    fun run() {
        println("$name is running!")
        println("Speed Player: $speed")
    }

    // Definisi isDead untuk memeriksa kesehatan player
    val isDead: Boolean
        get() = if(healthPoin <= 0) true else false
}

object RoomGame {
    @JvmStatic
    fun main(args: Array<String>){

        // Inisialisasi Object
        val player = Player()

        player.name = "Arka"
        player.speed = 80
        player.healthPoin = 0

        // Running Method
        player.run()

        if (player.isDead) println("Game Over!")

    }
}