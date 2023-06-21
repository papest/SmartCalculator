const val LONG_ENOUGH = 7
fun main() {
    val list = readln().split(" ")
    val res = list.first { it.length > LONG_ENOUGH }
    println(res)
}