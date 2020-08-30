package com.erdin.latihanandroidweek1.oop

class Car(var typeName: String, val model: String, var price:Double,
          val kmDrive: Int, val owner: String) {

    init {
        println("Object class Car is running!...")
    }

    fun getCarPrice():Double {
        return price - (kmDrive.toDouble()*10)
    }

}

fun main() {

//    val car = Car("BWM", "2010", 900000.0, 135, "Erdin")
//    println(car.typeName)
//    println(car.model)
//    println(car.owner)
//    println(car.getCarPrice())
//
//    val car2 = Car("Toyota", "2020", 250000.0, 15,"Ichsan")
//    println(car2.typeName)
//    println(car2.model)
//    println(car2.owner)
//    println(car.getCarPrice())

    val listOfCar = arrayListOf<Car>()
    listOfCar.add(Car("BWM", "2010", 900000.0, 135, "Erdin"))
    listOfCar.add(Car("Toyota", "2020", 250000.0, 15,"Ichsan"))

    for (car in listOfCar) {
        println("List Of Car")
        println(car.model)
        println(car.getCarPrice())
    }

}