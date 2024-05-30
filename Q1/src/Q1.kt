fun main()
{
    val invoice: Invoice = Invoice("Michał", "Ogiń", "22", "jabko", 5, 5.2);
    println(invoice.buyerFullName +  " " + invoice.totalPrice);
    println( invoice.goodInfo());

    val person1: Person = Person(firstName = "John", lastName = "Smith", ssn = "0123456789", dateOfBirth = "1997-10-23", gender = 'M');
    val person2: Person = Person(firstName = "John", lastName = "Smith", dateOfBirth = "1997-10-23", gender = 'M');

    var gameUser: GameUser = GameUser(firstName = "John", lastName = "Doe", userName = "jdoe", birthday = "1900-01-01",
        registrationNumber = 0, userRank = 0.0
    )

}

class Invoice(val buyerFirstName:String, val buyerLastName:String,
              val date:String, val goodName:String, val amount:Int, val pricePerItem:Double)
{
    val buyerFullName:String = "$buyerFirstName $buyerLastName";
    val totalPrice:Double = amount * pricePerItem;

    fun goodInfo():String = "$amount kawałków $goodName ";
}

class Person(var firstName:String, var lastName:String, var ssn:String = "", var dateOfBirth:String, var gender:Char)
{
    constructor(firstName: String, lastName: String, ssn: String, gender: Char)
            : this(firstName, lastName, ssn, "0000-00-00", gender)
}

data class Color2(val red: Int, val green: Int, val blue: Int) {
    init {
        require(red in 0..255) { "Red component must be between 0 and 255" }
        require(green in 0..255) { "Green component must be between 0 and 255" }
        require(blue in 0..255) { "Blue component must be between 0 and 255" }
    }
}