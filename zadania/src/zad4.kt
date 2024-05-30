abstract class FibonacciCalculator
{
    abstract fun calculateFibonacci(number : Int) : Long
}

class MemoizedFibonacciCalculator : FibonacciCalculator()
{
    private val cache = mutableMapOf<Int, Long>();

    override fun calculateFibonacci(number: Int): Long
    {
        if(number < 2)
        {
            return number.toLong();
        }

        if(cache.containsKey(number))
        {
            return cache[number]!!;
        }

        val result = calculateFibonacci(number - 1) + calculateFibonacci(number - 2);
        cache[number] = result;
        return result;
    }
}

class RecursiveFibonacciCalculator : FibonacciCalculator()
{
    override fun calculateFibonacci(number: Int): Long
    {
        if(number < 2)
        {
            return number.toLong();
        }
        return calculateFibonacci(number - 1) + calculateFibonacci(number - 2);
    }
}

fun zad4()
{
    while(true) {
        println("1 - Recursive Fibonacci ")
        println("2 - Memoized Fibonacci ")
        println("3 - Exit ")

        val choice = readlnOrNull()?.toIntOrNull()

        when(choice) {
            1 -> {
                println("Enter the value of n:");
                val n = readlnOrNull()?.toIntOrNull() ?: return;
                println("Fibonacci($n) = ${RecursiveFibonacciCalculator().calculateFibonacci(n)}");
            }
            2 -> {
                println("Enter the value of n:");
                val n = readlnOrNull()?.toIntOrNull() ?: return;
                println("Fibonacci($n) = ${MemoizedFibonacciCalculator().calculateFibonacci(n)}");
            }
            3 -> {
                return;
            }
            else -> println("Invalid choice.");
        }
    }
}