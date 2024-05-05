fun Zad2()
{
    val differentProductManagerInterface: DifferentProductManagerInterface = DifferentProductManager();
    val adapter: Adapter = SystemAdapter(differentProductManagerInterface)
    val bridge = ProductBridge()

    val newProduct = Product(2, "Nowy Produkt", 20.0)
    adapter.addProduct(newProduct)


    val product = adapter.getProduct(1.toString())
    println("Pobrany produkt: ${product.name}")

    val productToConvert = Product(3, "Produkt do konwersji", 15.0)
    val differentProductToConvert = DifferentProduct("5", "Produkt do innej konwersji", 43.0)
    val convertedProduct = bridge.convert(differentProductToConvert);
    val convertedDifferentProduct = bridge.convert(productToConvert)
    println("Skonwertowany produkt: ${convertedProduct.id} ${convertedProduct.name} ${convertedProduct.price}")
    println("Skonwertowany inny produkt: ${convertedDifferentProduct.productId} ${convertedDifferentProduct.name} ${convertedDifferentProduct.price}")
}

class Product(val id: Int, val name : String, val price: Double)
{
}

class DifferentProduct(val productId: String, val name : String, val price: Double)
{
}

interface ProductManager {
    fun getProduct(id: Int): DifferentProduct
    fun addProduct(differentProduct: DifferentProduct)
}

interface DifferentProductManagerInterface {
    fun getProductById(productId: String): Product
    fun addProduct(product: Product)
}

class DifferentProductManager : DifferentProductManagerInterface {
    override fun addProduct(product: Product) {
        println("Adding Product");
    }

    override fun getProductById(productId: String): Product {
        return Product(1, productId, 0.0);
    }
}

interface Adapter {
    fun getProduct(id: String): Product
    fun addProduct(product: Product)
}

class SystemAdapter(private val innySystem: DifferentProductManagerInterface) : ProductManager, Adapter {
    override fun getProduct(id: Int): DifferentProduct {
        return ProductBridge().convert(innySystem.getProductById(id.toString()))
    }

    override fun addProduct(differentProduct: DifferentProduct) {
        innySystem.addProduct(ProductBridge().convert(differentProduct))
    }

    override fun getProduct(id: String): Product {
        return innySystem.getProductById(id)
    }

    override fun addProduct(product: Product) {
        innySystem.addProduct(product)
    }
}

interface Bridge {
    fun convert(differentProduct: DifferentProduct): Product
    fun convert(product: Product): DifferentProduct
}

class ProductBridge : Bridge {
    override fun convert(differentProduct: DifferentProduct): Product {
        return Product(differentProduct.productId.toInt(), differentProduct.name, differentProduct.price)
    }

    override fun convert(product: Product): DifferentProduct {
        return DifferentProduct(product.id.toString(), product.name, product.price)
    }
}