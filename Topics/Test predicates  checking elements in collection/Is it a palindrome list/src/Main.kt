fun main() {
    val list = readln().split(" ")
    println(!list.any { it.reversed() != it })
}