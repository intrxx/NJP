class Email private constructor(
    val sender: String,
    val recipient: String,
    val topic: String,
    val content: String?)
{
    class EmailBuilder
    {
        private var sender: String = "";
        private var recipient: String = "";
        private var topic: String = "";
        private var content: String? = "";

        fun setSender(sender: String) = apply { this.sender = sender };
        fun setRecipient(recipient: String) = apply { this.recipient = recipient };
        fun setTopic(topic: String) = apply { this.topic = topic };
        fun setContent(content: String?) = apply { this.content = content };

        fun build() = Email(sender, recipient, topic, content);
    }
}

fun zadanie4()
{
    println("\n Zadanie 4");

    val emails = listOf<Email>(
        Email.EmailBuilder().setSender("Damian").setRecipient("Michal").setTopic("Zadanie 4 NJP").setContent("...").build(),
        Email.EmailBuilder().setSender("Mikolaj").setRecipient("Adam").setTopic("Globalne ocieplenie").build(),
        Email.EmailBuilder().setSender("Ania").setRecipient("Klaudia").setTopic("Wiersz").build()
    );

    for(item in emails)
    {
        println("Sender: ${item.sender} Recipient: ${item.recipient} Topic: ${item.topic} Content: ${item.content}");
    }
}