class Product private constructor(val Name: String, val Price: Double, val Availability: Boolean)
{
    companion object
    {
        fun Create(Name: String, Price: Double, Availability: Boolean) : Product
        {
            return Product(Name, Price, Availability);
        }
    }
}
class ProductFactory
{
    fun CreateProduct(Name: String, Price: Double, Availability: Boolean) : Product
    {
        return Product.Create(Name, Price, Availability);
    }
}

fun Zadanie3()
{
    val productFactory = ProductFactory();
    val products = listOf<Product>(
        productFactory.CreateProduct("Banana", 5.0, true),
        productFactory.CreateProduct("Apple", 3.0, true),
        productFactory.CreateProduct("Orange", 8.0, false)
    );

    println("Zadanie 3");

    for(item in products)
    {
        println("Name: ${item.Name} Price: ${item.Price} Availability: ${item.Availability}");
    }
}