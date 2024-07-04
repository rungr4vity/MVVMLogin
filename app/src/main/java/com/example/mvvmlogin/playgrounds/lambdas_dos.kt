package com.example.mvvmlogin.playgrounds

fun main() {


//    getInfo { value ->
//        println(value)
//    }

    println(resultado("My value1").isSuccess)

}




fun getInfo(displayInfo:(lista: List<String>) -> Unit) {
    val myList: List<String> = listOf("apple", "banana", "apple", "orange", "banana")
    displayInfo(myList)
}

fun resultado(value1: String): Result<String> {

    if(value1.isEmpty()) {
        return Result.failure(Exception("Error"))
    }

    return Result.success(value1)

}