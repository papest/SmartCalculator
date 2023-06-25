fun main() {
    val list = readln().split(" ").map { it.toInt() }
    println(list.sortedDescending())
}