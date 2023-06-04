fun findLongestByIterator(strIterator: Iterator<String>): String =
    strIterator.asSequence().maxByOrNull { it.length } ?: ""

fun main() {
    val words: List<String> = readLine()!!.split("\\s+".toRegex())
    println(findLongestByIterator(words.iterator()))
}