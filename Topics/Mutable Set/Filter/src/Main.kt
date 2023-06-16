fun evenFilter(numbers: Set<Int>): Set<Int> {
    val result = mutableSetOf<Int>()
    for (i in numbers) {
        if (i % 2 == 0) result.add(i)
    }
    return result
}
