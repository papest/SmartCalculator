fun main() {
    val words: List<String> = readln().split(" ")
    if (words.distinctBy { it.first() }.size < 2) {
        println(words.joinToString(" "))
    }
}