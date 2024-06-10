package com.example.mvvmlogin.playgrounds

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val info = getInfo()
}


fun returnList(): List<Int> {
    var myList = mutableListOf<Int>()


    for(i in 1..100000){
        myList.add(i)
    }

    return myList
    //0.rangeTo(1000).toList()
}

suspend fun getInfo(): Unit = coroutineScope{
    val info = async {
        returnList()
    }

    info.await()
    println("Completed")
}