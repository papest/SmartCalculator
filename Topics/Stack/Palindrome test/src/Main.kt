import java.util.*

fun checkPalindrome(word: String): Boolean {
    return Stack<Char>()
        .run {
            addAll(word.toList())
            List(this.size) { pop() }.joinToString("") == word
        }
}

fun main() {
    val input = readln()

    println(checkPalindrome(input))

}