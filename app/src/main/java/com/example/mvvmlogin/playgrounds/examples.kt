
fun main() {


    //val myInput = listOf<Int>(1,4,4,5,6,88,88,90)
    //print(myInput.zipWithNext())

    //print(duplicates(myInput).toString())

    //val myList = listOf<String>("Paco")




    //val myList = "Paco"
    //goreverse(myList)


    val mynumber = 19087
    //reverseNumber(mynumber.toString())

    reverseInt(mynumber)
}


fun reverseInt(input: Int) {

    var n = input
    var result = 0

    while(n>0){

        result = result * 10 + n % 10
        n /= 10
    }

    print(result)

}

fun reverseNumber(input: String) {

    var result = ""
    input.forEach {

        result = it + result

        println(result)
    }


}

fun goreverse(input: String) {
    var result = ""
    input.forEach {

        result = it.toString() + result
    }
    println(result)
}



//fun duplicates(input:List<Int>) = input.toSet()
