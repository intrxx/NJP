data class Contact(val firstName: String, val lastName: String, val phoneNumber: String)

class ContactManager(private val contacts: List<Contact>)
{
    fun getSortedContacts(comparator: (Contact, Contact) -> Int): List<Contact>
    {
        return contacts.sortedWith(comparator)
    }
}

fun zad6()
{
    val contactManager = ContactManager(listOf(
        Contact("Jan", "Kowalski", "542-323-255"),
        Contact("Kuba", "Hyc", "234-251-231"),
        Contact("Daniel", "Kubiak", "264-247-172")
    ));
    
    val sortedByName = contactManager.getSortedContacts { contact1, contact2 -> contact1.firstName.compareTo(contact2.firstName) }
    println("Sorted by name: ${sortedByName.joinToString { it.firstName }}")
    
    val sortedByLastName = contactManager.getSortedContacts { contact1, contact2 -> contact1.lastName.compareTo(contact2.lastName) }
    println("Sorted by lastName: ${sortedByLastName.joinToString { it.lastName }}")
    
    val sortedByPhoneNumber = contactManager.getSortedContacts { contact1, contact2 -> contact1.phoneNumber.compareTo(contact2.phoneNumber) }
   println("Sorted by phoneNumber: ${sortedByPhoneNumber.joinToString { it.phoneNumber }}")
}