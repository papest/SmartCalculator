import kotlin.concurrent.thread
const val COUNT = 100000
const val BUFFER_SIZE = 200000

fun addNumbers(numbers: StringBuffer) {
    for (i in 0 until COUNT) numbers.append(i.toString().first())
}

fun main() {
    val numbers = StringBuffer(BUFFER_SIZE)
    val thread = thread(start = false, name = "Thread 1") {
        addNumbers(numbers)
    }

    thread.start()
    addNumbers(numbers)

    thread.join()

    println(numbers.length)
}