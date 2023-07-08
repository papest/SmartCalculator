fun getEvenNumbers(mutableIterator: MutableIterator<Int>): List<Int> {
    return mutableListOf<Int>().apply {
        while (mutableIterator.hasNext()) {
            val next = mutableIterator.next()
            if (next % 2 == 0) this.add(next)
        }
    }
}