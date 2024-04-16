package com.example.mvvmlogin.playgrounds

fun main() {

    println(getVowels("My first func"))
}

fun getVowels(input: String) =
    input.toCharArray()
        .count{ it in "aeiou" }

