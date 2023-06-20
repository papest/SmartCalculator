fun main() {
    val list = readln().split(" ")
    val res = list.associateBy { it.first().uppercase() }
    println(res)
}