import kotlin.math.sqrt

@SuppressWarnings("MagicNumber")
fun main() {
    val (a, b, c) = List(3) { readln().toDouble() }
    ((a + b + c) / 2).let { println(sqrt(it * (it - a) * (it - b) * (it - c))) }
}