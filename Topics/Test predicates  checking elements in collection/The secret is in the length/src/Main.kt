const val NUMBER = 4
fun main() {
    val list = readln().split(" ")
    println(!list.any { it.length <= NUMBER })
}