
import jdk.jpackage.internal.Log
import java.time.*
import java.time.format.DateTimeFormatter

fun main()
{
    val repeatString: (String, Int) -> String = { s:String, num:Int -> s.repeat(num) }
    val f : (String) -> String = { "$it!" }
    val quad = Quadruple(5, 3, 8.47, "Quad");

    val l1 = listOf(
        Employee("Smith", "Eve", "012-12-5678"),
        Employee("Carpenter", "John", "123-06-4901"),
        Employee("Cugar", "Clara", "034-00-1111"),
        Employee("Lionsgate", "Peter", "965-11-4561"),
        Employee("Disney", "Quentin", "888-12-3412")
    )
    
    val sortedList = l1.sortedBy() { employee -> employee.ssn }
    val map = l1.associateBy() {it.ssn}

    listOf(listOf(1, 2), listOf(3, 4)).flatten()

    val zeroSSN = l1.filter { it.ssn.startsWith("0")} 
    
    val greaterThenZero = listOf(1, 2, 3, 4).all { it > 0 };

    val l2 = listOf(1, 2, 3, 4, 5, 6, 7, 8, 42)
    
   // l2.find{ it == 42 }?.run{ throw Exception("list contains 42") }

    val l = listOf( 
        Parcel(1267395, 1.45),
        Parcel(1515670, 0.46),
        Parcel(8345674, 2.50), 
        Parcel(3418566, 1.47),
        Parcel(3491245, 3.04)
    )
    
    l.sumOf { it.weight }

    operator fun String.rem(regex:String): Boolean
    {
        return this.matches(Regex(regex));
    } 
    val r = "Hello" % ".*ll.*";
}

class ClockTwiceAsFast : Clock() 
{
    private val myStartInstant : Instant = Clock.systemUTC().instant()

    override fun withZone(zone: ZoneId?): Clock = this
    override fun getZone(): ZoneId = ZoneId.of("Z")
    override fun instant(): Instant 
    {
        val duration = Duration.between(myStartInstant, Clock.systemUTC().instant()).multipliedBy(2L)
        return myStartInstant.plus(duration)
    }
}


class Parcel (val receiverId: Int, val weight: Double)

class Employee(val name: String,val surname: String, val ssn: String) {
}

class Quadruple<A,B,C,D>(var elem1:A, var elem2:B, var elem3:C, var elem4:D)
{
}

class Sorter<T : Comparable<T>> 
{
    private val list: MutableList<T> = mutableListOf()
    
    fun add(value:T) 
    {
        list.add(value)
        list.sort()
    }
}


@Target(AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.RUNTIME)
annotation class NotNegative()









