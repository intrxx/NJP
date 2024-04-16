class AProductFactory
{
    fun CreateProduct(type: String): AProduct?
    {
        return when(type)
        {
            "Laptop" -> Laptop();
            "Smartphone" -> Smartphone().Create();
            "Headphones" -> Headphones().Create();
            else -> null;
        }
    }
}
abstract class AProduct
{
    abstract fun Create() : AProduct;
}
class Laptop : AProduct()
{
    override fun Create() : Laptop
    {
        return Laptop();
    };
}
class Smartphone : AProduct()
{
    override fun Create() : Smartphone
    {
        return Smartphone();
    };
}
class Headphones : AProduct()
{
    override fun Create() : Headphones
    {
        return Headphones();
    };
}

fun zadanie2()
{
    println("\n Zadanie 2");
    
    val aProductFactory = AProductFactory();

    val aProducts = listOf<AProduct?>(
        aProductFactory.CreateProduct("Laptop"),
        aProductFactory.CreateProduct("Smartphone"),
        aProductFactory.CreateProduct("Headphones"))

    println(aProducts);
}