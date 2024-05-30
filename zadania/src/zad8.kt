fun factorialList(numbers: List<Int>): List<Int>
{
    tailrec fun factorial(n: Int, acc: Int = 1): Int
    {
        if(n == 0)
        {
            return acc
        }
        return factorial(n - 1, acc * n);
    }

    tailrec fun factorialListHelper(numbers: List<Int>, result: List<Int> = emptyList()): List<Int>
    {
        if(numbers.isEmpty())
        {
            return result;
        }
        return factorialListHelper(numbers.drop(1), result + factorial(numbers.first()));
    }

    return factorialListHelper(numbers);
}

fun zad8()
{
    println(factorialList(listOf(2, 3, 4, 5)));
}