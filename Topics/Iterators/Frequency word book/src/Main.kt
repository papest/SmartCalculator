fun main() {
    val list = readln().split(" ")
    list.toSet()
        .forEach { println("$it ${list.count { i -> it == i }}") }
}