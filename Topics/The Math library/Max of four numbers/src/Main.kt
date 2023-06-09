import kotlin.math.max

const val COUNT = 4

fun main() {
    var max = Int.MIN_VALUE
    repeat(COUNT) { max = max(max, readln().toInt()) }
    println(max)
}