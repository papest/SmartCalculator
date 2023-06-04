const val MAGIC_LENGHT = 7
fun main() {
    val list = readln().split(" ")
    println(list.first { it.length > MAGIC_LENGHT })
}