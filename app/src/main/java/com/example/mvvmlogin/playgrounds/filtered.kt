package com.example.mvvmlogin.playgrounds

fun main() {


    var myList: List<String> = listOf("apple", "banana", "apple", "orange", "banana")
    var myHashmap: HashMap<String, Boolean> = HashMap()
    var finalList: ArrayList<String> = ArrayList()

    myList.forEach { value ->
        if (!myHashmap.containsKey(value)) {
                myHashmap[value] = true
                finalList.add(value)
        }
    }

    println(finalList.toString())



}
