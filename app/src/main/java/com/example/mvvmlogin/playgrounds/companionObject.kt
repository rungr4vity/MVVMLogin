package com.example.mvvmlogin.playgrounds

fun main() {

    //Numbers.getInfo()
    //print(Numbers.appName)
    Apple.randomNumber()
}

class Apple {


    // whats a companion object
    // Companion objects are routinely presented as an alternative to static
    // in this example randomNumber can accessed as a singleton


    // in the other hand an Object (Numbers.kt) can be used as a singleton as well,don't need an instance
    companion object {
        private var x = 0
        private const val y = 30
        fun randomNumber() {
            val random = (x..y).random()

            println("Random number = $random")
        }
    }



} // end class apple