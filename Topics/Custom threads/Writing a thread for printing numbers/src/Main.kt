class NumbersThread(private val from: Int, private val to: Int) : Thread() {
    override fun run() {
        for (i in from..to) println(i)
    }
}