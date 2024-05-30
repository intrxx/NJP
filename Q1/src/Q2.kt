import java.util.*
import kotlin.math.floor

fun main()
{
    val a = 42
    val s = "Jeśli dodamy 4 do a otrzymamy + (${a + 4})"
    println(s);

    val person = Person1()
    person.setName(lName = "Doe", fName = "John")

}

class Person1 {
    var firstName:String? = null
    var lastName:String? = null
    fun setName(fName:String, lName:String) {
        firstName = fName
        lastName = lName
    }
}

interface AInterface
{
    fun add(b:Int):Int
    fun mult(b:Int):Int
}



class sA {
    var a:Int = 1

    init
    {
        a = 2
    }
    fun b()
    {
        a = 3
    }
}

interface RandomNumberGenerator
{
    fun rnd(minInt:Int, maxInt:Int): Int
}

class StdRandom : RandomNumberGenerator
{
    override fun rnd(minInt: Int, maxInt: Int): Int
    {
        val span = maxInt - minInt + 1
        return minInt + floor(Math.random() * span).toInt()
    }
}

class RandomRandom : RandomNumberGenerator
{
    private val rnd:Random = Random()
    override fun rnd(minInt: Int, maxInt: Int):Int
    {
        val span = maxInt - minInt + 1
        return minInt + rnd.nextInt(span)
    }
}

class MainActivity
{
    private var randomNumberGenerator: RandomNumberGenerator = StdRandom()
    fun start()
    {
        val randomNumber = randomNumberGenerator.rnd(1, 100)
        println("Generated random number: $randomNumber")
    }

    fun setRandomNumberGenerator(rng: RandomNumberGenerator)
    {
        this.randomNumberGenerator = rng
    }
}


interface ElementaryParticle
{
    fun mass():Double;
    fun charge():Double;
    fun spin():Double;
}

class Electron : ElementaryParticle
{
    override fun mass():Double = 9.11e-31;
    override fun charge():Double = -1.00;
    override fun spin():Double = 0.5;
}

class Proton : ElementaryParticle
{
    override fun mass():Double = 1.67e-27;
    override fun charge():Double = 0.5;
    override fun spin():Double = 0.5;
}

class Triangle(val sideA: Double, sideB: Double, sideC: Double)
{
    companion object
    {
        const val NUMBER_OF_CORNERS:Int = 3;
    }

    fun info() : Int
    {
        return NUMBER_OF_CORNERS;
    }
}

object Constants
{
    const val numbersOfTabs:Int = 5;
    const val windowTile:String = "Astaria";
    const val prefsFile:String = "prefs.properties"

    fun printConstants()
    {
        println("Constant values: \n " +
                "numbers of tabs: $numbersOfTabs \n " +
                "windows tile: $windowTile \n " +
                "prefs file: $prefsFile")
    }
};