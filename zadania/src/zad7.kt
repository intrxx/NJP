tailrec fun recursiveTailrecSum(lst: List<Int>, acc: Int = 0): Int {
    if(lst.isEmpty())
    {
        return  acc;
    }
    return recursiveTailrecSum(lst.drop(1), acc + lst.first())
}

fun zad7()
{
    println("Sum of all the elements: ${recursiveTailrecSum(listOf(1, 2, 3, 4, 5))}")
}