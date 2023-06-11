const val COUNT = 3
fun main() {
    println(List(COUNT) { readln().toInt() }.sumOf { it / 2 + it % 2 })
}