const val NUMBER = 4
fun main() {
    val list = readln().split(" ")
    val res = list.sumOf { if (it.length < NUMBER) 0 else it.length }
    println(res)
}