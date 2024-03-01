

data class Cats(val name: String,val age: Int)


fun main() {

    val cats =  listOf(
        Cats("Tom",5),
        Cats("Patrick",10),
        Cats("Mario",7),
        Cats("Giuseppe",2)
    )
    val oldestCat = cats.maxBy {
        it.age
    }
    println("The oldest cat is ${oldestCat.name}")




    val greeting = { println("Hello mate!") }
    //greeting()

    val sum = { a: Int, b:Int -> a + b }
    val result = sum(5,10)

    println(result)

}