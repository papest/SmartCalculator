class Solution {
    private val numbers = charArrayOf('5', '9', 'a', 'c', 'a', '7', '8', '5', '1', '3')
    val positiveNumbers = numbers.filter { it.isDigit() && it > '4' }
}
