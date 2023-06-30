@Suppress("MagicNumber")
class Solution {
    private val peaceWords = arrayOf("I", "&&n", 3, "love", 1, "peace", "&&n")
    private val pattern = Regex("\\d+|&&n")
    val filteredPeaceWords = peaceWords.filter {
        if (pattern.matches(it.toString())) {
            return@filter false
        }
        true
    }
}