package com.example.mvvmlogin.playgrounds

fun main() {

    val input = "abcddefg"

    print(firstLetter(input))

}

fun recorre (input: String) {

    input.toCharArray().forEach {
        println(it)
    }
}


fun firstLetter(input: String) {

    var toMap = mutableMapOf<String,String>()
    input.toCharArray().forEach {

        if (toMap.containsKey(it.toString())) {
            println(it.toString())
        } else {
            toMap[it.toString()] = it.toString()
        }

    }
}