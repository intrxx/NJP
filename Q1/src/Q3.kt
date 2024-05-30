import java.lang.Math.log
import java.lang.foreign.ValueLayout
import kotlin.math.ln

class A {
    fun calc(a:Double) = ln(a)
}
class Color(private val red: Int, private val green: Int, private val blue: Int) {
    val str: String
        get() = toString()

    override fun toString(): String {
        return "Color(red=$red, green=$green, blue=$blue)"
    }
}

fun main() {
    val color = Color(255, 200, 155)
    println(color.str) // Zwróci: Color(red=255, green=200, blue=155)
    println(color.toString()) // Zwróci: Color(red=255, green=200, blue=155)

    val arr = IntArray(101) { i -> 100 - i };
    val boolArr = booleanArrayOf(true, false, true);

    //val fruits = mutableSetOf("Apple", "Banana", "Grape", "Engine")
    //fruits.add("Cherry")
    //fruits.remove("Engine")
    //val fruits5 = fruits.filter { element -> element.length == 5 }

    val number = (1 .. 100).toList().reduce() {acc,v -> acc*v};

    val fruits = listOf("Bananas", "apples", "Oranges")
    val prices = listOf(1.69, 2.19, 2.79)
    data class Fruit(val name:String, val price:Double)
    val zipped = fruits.zip(prices) { a, b -> Fruit(a, b) }
    println(zipped);
}

data class Vector(val dx:Double, val dy:Double) {
    operator fun plus(v2:Vector) = Vector(this.dx + v2.dx, this.dy + v2.dy)
    operator fun minus(v2:Vector) = Vector(this.dx - v2.dx, this.dy - v2.dy)
}

class Concatenator {
    private var string:String = "";
    fun add(s:String)
    {
        string += s;
    }
    operator fun contains(other:String) = string.contains(other)
}

open class As() {
    open var g:Int = 99
    fun x() {
        println("A.x() : g = ${g}")
    }
    fun q() {
        println("A.q() : g = ${g}")
    }
}
class B : As() {
    override var g:Int = 8
    fun y() {
        println("B.y() : g = ${g}")
        q()
    }
}

class Club {
    fun addMembers(vararg names:String)
    {
        println("Numbers: " + names.size)
        println(names.joinToString(" : "))
    }
}




