fun main() {
    val string = readln()
    val index = readln().toInt()
    println(
        try {
            string[index]
        } catch (e: StringIndexOutOfBoundsException) {
            "Out of bounds!"
        }
    )
}