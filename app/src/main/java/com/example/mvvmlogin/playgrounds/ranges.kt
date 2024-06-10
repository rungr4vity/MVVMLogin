package com.example.mvvmlogin.playgrounds

fun main() {
    val result = minutesToHour(430)
    val result2 = minutesToHour(490)
    println("${result.toString()} - ${result2.toString()}")

    val result3 = minutesToHour(475)
    val result4 = minutesToHour(520)
    println("${result3.toString()} - ${result4.toString()}")


    val range1 = TimeRange(430, 490) //7:10-8:10
    val range2 = TimeRange(475, 520) //7:55-8:40
    println("Range1 and Range2 overlap: ${doRangesOverlap(range1, range2)}") // se empalma SI




   //print(isValidTimeRange(Time(7, 10), Time(8, 10)))


//    val range1 = TimeRange(9, 12)
//    val range2 = TimeRange(11, 14)
//    val range3 = TimeRange(13, 15)
//
//    println("Range1 and Range2 overlap: ${doRangesOverlap(range1, range2)}") // Output: true
//    println("Range1 and Range3 overlap: ${doRangesOverlap(range1, range3)}") // Output: false
}

data class Time(val hours: Int, val minutes: Int)
fun isValidTimeRange(startTime: Time, endTime: Time): Boolean {
    if (endTime.hours > startTime.hours) return true
    if (endTime.hours == startTime.hours && endTime.minutes > startTime.minutes) return true
    return false
}








fun minutesToHour(min: Int): String {
    val hour = min / 60
    val minute = min % 60
    return "$hour:$minute"
}


data class TimeRange(val start: Int, val end: Int)
fun doRangesOverlap(range1: TimeRange, range2: TimeRange): Boolean {
    // Check if the ranges overlap
    return range1.start < range2.end && range1.end > range2.start
}

