fun main() {
    val list = readln().split(" ").map { it.toInt() }
    list.indices
        .map { if (it % 2 == 0) it shr 1 else list.lastIndex - (it shr 1) }
        .map { list[it] }
        .joinToString(" ")
        .let { println(it) }
}