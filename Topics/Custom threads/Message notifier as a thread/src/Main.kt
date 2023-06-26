class MessageNotifier(private val message: String, private val number: Int) : Thread() {
    override fun run() {
        repeat(number) { println(message) }
    }
}