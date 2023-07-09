fun main() {
    val list = readln().split(" ")
    with(list.toMutableList()) { while (isNotEmpty()) print("${removeLast()} ") }
}