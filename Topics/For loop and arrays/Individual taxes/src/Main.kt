fun main() {
    val count = readln().toInt()
    val array = Array(count) { readln().toInt() }
    val taxes = Array<Long>(count) { readln().toLong() }
    for (i in array.indices) {
        taxes[i] = array[i] * taxes[i]
    }
    println(taxes.indexOf(taxes.maxOrNull()) + 1)
}