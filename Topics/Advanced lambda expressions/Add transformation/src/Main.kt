class Solution {
    fun applyTransformation(numbers: List<Int>, transformation: (Int) -> Int): List<Int> = numbers.map(transformation)
}