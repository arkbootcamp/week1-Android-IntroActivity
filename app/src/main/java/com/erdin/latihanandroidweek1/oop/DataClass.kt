package com.erdin.latihanandroidweek1.oop

data class Person(val name:String, val age: Int, val sex:String)

fun main() {
    val person = Person("Ichsan", 23, "M")
    println(person.name)
}