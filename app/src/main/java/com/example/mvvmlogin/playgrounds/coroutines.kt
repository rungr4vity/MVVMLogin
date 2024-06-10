package com.example.mvvmlogin.playgrounds



fun main() {

    val myString: String? = null

    println(myString.toString() ?: "my null")

}

fun String.getInfo(): String {
    return "from extension"
}