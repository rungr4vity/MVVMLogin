package com.example.mvvmlogin.playgrounds

fun main() {

    var myList = listOf<Int>(3,4,4,566,6,9,7,788,8,8,8,8)

    print(eliminateDuplicates(myList))
    //print(highNumber(myList))
   //print(maxOccurrence("aabbcccdddd"))
}

fun eliminateDuplicates(input: List<Int>): List<Int> {
    return input.toSet().toList()
}

fun highNumber(input: List<Int>): Int? {
    return input.groupBy { it }
        .maxByOrNull { it.value.size }
        ?.key
}

//var mystring = "my string"
//println(mystring.toList())

fun maxOccurrence(input: String): Char? {

    return input.toCharArray()
        .groupBy { it }
        .maxByOrNull { it.value.size}
        ?.key
}