import kotlin.math.sqrt

@Suppress("MagicNumber")
fun main() {
    val (a, b, c) = List(3) { readln().toDouble() }
    val sqrtD = sqrt(b * b - 4 * a * c)
    println(listOf((-b - sqrtD) / 2.0 / a, (-b + sqrtD) / 2.0 / a).sorted().joinToString(" "))
}