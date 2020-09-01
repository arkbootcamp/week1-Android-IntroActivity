package com.erdin.latihanandroidweek1.oop

import androidx.lifecycle.Transformations.map

data class Person(var name:String?, var age: Int?, var sex:String?) {

}

fun main() {
    Person("Ichsan", 23, "M")
    Person("Ichsan2", 23, "M")
    Person("Ichsan3", 23, "M")
    Person("Ichsan4", 23, "M")
    Person("Ichsan5", 23, "M")
    val person = Person("Ichsan", 23, "M")




}