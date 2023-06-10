import java.util.logging.Level

fun main() {
    println(readln().split(" ").sumOf { Level.parse(it.uppercase()).intValue() })
}