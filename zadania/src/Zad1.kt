import java.math.BigDecimal

class Order(private val products: List<Pair<String, Int>>)
{
    fun addProduct(product: String, quantity: Int) : Order
    {
        val updatedProducts = products.toMutableList();
        updatedProducts.add(product to quantity);
        return Order(updatedProducts);
    }

    private fun getProductPrice(productName: String): BigDecimal
    {
        return when (productName)
        {
            "P1" -> BigDecimal("5.0");
            "P2" -> BigDecimal("10.0");
            "P3" -> BigDecimal("20.0");
            "P4" -> BigDecimal("50.00");
            "P5" -> BigDecimal("100.00");
            else -> BigDecimal.ZERO;
        }
    }

    fun calculateTotalPrice(): BigDecimal
    {
        return products.map {
                (productName, quantity) -> getProductPrice(productName).multiply(BigDecimal(quantity))
        }.fold(BigDecimal.ZERO, BigDecimal::add);
    }
}

fun zad1()
{
    val order = Order(emptyList());
    val updatedOrder = order.addProduct("P2", 3);
    val updatedOrder2 = updatedOrder.addProduct("P4", 5);
    println("Total price: ${updatedOrder2.calculateTotalPrice()}");
}