@Suppress("MagicNumber")
fun main() {
    val set = setOf(12, 34, 235, 2343, 1, 3, 4564, 23, 5, 6, 123545, 464)
    val choice = readln()
    val number = readln().toInt()
    println(if (choice == "first") set.firstOrNull { it > number } else set.lastOrNull { it > number })
}