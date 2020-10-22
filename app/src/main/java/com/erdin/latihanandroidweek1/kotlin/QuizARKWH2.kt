package com.erdin.latihanandroidweek1.kotlin

private fun reversePyramid(row: Int) {
    var x: String? = ""
    var col = row + (row - 1)
    for (i in 1..row) {
        for (j in 1..i) {
            x += "_"
        }
        for (k in 1..col) {
            x += "*"
        }

        col -= 2
        x += "\n"
    }
    print(x)
}

private fun reversePyramid2(row: Int) {
    var x: String? = ""
    for (i in row downTo 1) {
        x += "_".repeat(row-i)
        x += "*".repeat(i*2-1)
        x += "\n"
    }
    print(x)
}

private fun reversePyramid3(row: Int) {
    var x: String? = ""
    for (i in 1..row) {
        for (j in 1..i) {
            x += "_"
        }
        for (k in i..row) {
            x += "*"
        }
        for (l in i+1..row) {
            x += "*"
        }
        x += "\n"
    }
    print(x)
}

fun main(){
//    reversePyramid(3)
//    reversePyramid2(3)
    reversePyramid3(3)
}