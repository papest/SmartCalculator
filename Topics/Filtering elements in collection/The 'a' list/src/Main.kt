fun main() {
    val list = readln().split(" ")
    val res = list.filter { it.isNotEmpty() && it.last() == it.first() && it.last() == 'a' }
    println(res)
}