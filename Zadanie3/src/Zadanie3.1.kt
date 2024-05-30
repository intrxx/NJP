fun zad1() {
    val product1: Product = Product(".", 5.0, StandardDelivery())
    val product2: Product = Product("..", 10.0, ExpressDelivery())
    val product3: Product = Product("...", 20.0, EconomicDelivery())
    val set = mutableSetOf<Product>();
    set.add(product1);
    set.add(product2);
    set.add(product3);
    
    set.forEach { 
        println("Nazwa: ${it.name}, waga: ${it.weight}, typ dostawy: ${it.getDeliveryName()}, koszt: ${it.getCost()}");
    }
}

interface DeliveryStrategy {
    fun calculateDeliveryCost(weight: Double) : Double;
    fun getDeliveryName() : String;
}

class StandardDelivery() : DeliveryStrategy {
    override fun calculateDeliveryCost(weight: Double): Double {
        return weight * 12.5;
    }

    override fun getDeliveryName(): String {
        return "Standard";
    }
}

class ExpressDelivery() : DeliveryStrategy {
    override fun calculateDeliveryCost(weight: Double): Double {
        return weight * 20.0;
    }
    
    override fun getDeliveryName(): String {
        return "Express";
    }
}

class EconomicDelivery() : DeliveryStrategy {
    override fun calculateDeliveryCost(weight: Double): Double {
        return weight * 8.0;
    }
    
    override fun getDeliveryName(): String {
        return "Economic";
    }
}

class Product(val name: String, var weight: Double, var deliveryStrategy: DeliveryStrategy) {
    fun getCost() : Double {
        return deliveryStrategy.calculateDeliveryCost(weight);
    }
    
    fun getDeliveryName(): String {
        return deliveryStrategy.getDeliveryName();
    }
}