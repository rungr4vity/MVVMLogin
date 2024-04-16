fun main() {



    var list1 = listOf<Int>(1,34,55,67,8)
    var list2 = listOf<Int>(1,45,67,90)

    var mergedlist:List<Int> = eliminateDuplicates(list1,list2)

    mergedlist.forEach {
        print(",$it")
    }
}

fun <T> eliminateDuplicates(lista1:List<T>,lista2:List<T>): List<T> {

    var mergedlist = mutableSetOf<T>()
    mergedlist.addAll(lista1 + lista2)


    return mergedlist.toList()
}