import java.lang.Math.toDegrees
import kotlin.math.abs
import kotlin.math.atan2

fun main() {
    val (angleA, angleB) = List(2) { with(readln().split(" ")) { atan2(this[1].toDouble(), this[0].toDouble()) } }
    println(toDegrees(abs(angleA - angleB)))
}