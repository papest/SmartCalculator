@Suppress("MagicNumber")
fun main() {
    for (i in readln().toInt()..readln().toInt()) {
        when {
            i % 15 == 0 -> "FizzBuzz"
            i % 3 == 0 -> "Fizz"
            i % 5 == 0 -> "Buzz"
            else -> i
        }.let { println(it) }
    }
}