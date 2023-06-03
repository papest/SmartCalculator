package calculator

fun main() {
    readln()
        .split(" ")
        .sumOf { it.toInt() }
        .let { println(it) }
}
