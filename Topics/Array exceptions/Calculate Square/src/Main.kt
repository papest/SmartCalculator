fun calculateSquare(array: IntArray?, index: Int) {
    try {
        val element = array!!.get(index)
        println(element * element)

    } catch (e: Exception) {
        println("Exception!")
    }
}
