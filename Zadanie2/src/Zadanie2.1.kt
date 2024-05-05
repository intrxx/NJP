fun Zad1()
{
    val podstawoweZamowienie: Order = BasicOrder();
    println(podstawoweZamowienie.getCost());
    println(podstawoweZamowienie.getDesc());

    val zamowienieZDodatkowymSkladnikiem: Order = AdditionalComponentDecorator(podstawoweZamowienie);
    println(zamowienieZDodatkowymSkladnikiem.getCost());
    println(zamowienieZDodatkowymSkladnikiem.getDesc());

    val order2: Order = SpecialOrderDecorator(podstawoweZamowienie);
    println(order2.getCost());
    println(order2.getDesc());
}

interface Order
{
    fun getDesc() : String;
    fun getCost() : Double;
}

class BasicOrder : Order
{
    override fun getCost() : Double
    {
        return 10.0
    }
    override fun getDesc() : String
    {
        return "Podstawowe zamówienie";
    }
}

abstract class OrderDecorator(private val order : Order) : Order
{
    override fun getCost(): Double
    {
        return order.getCost();
    }
    override fun getDesc(): String
    {
        return order.getDesc();
    }
}

class AdditionalComponentDecorator(order: Order) : OrderDecorator(order)
{
    override fun getCost() : Double
    {
        return super.getCost() + 5.0;
    }
    override fun getDesc() : String
    {
        return super.getDesc() + " z ananasem";
    }
}

class SpecialOrderDecorator(order: Order) : OrderDecorator(order)
{
    override fun getCost() : Double
    {
        return super.getCost() + 10.0
    }
    override fun getDesc() : String
    {
        return super.getDesc() + " XXL"
    }
}