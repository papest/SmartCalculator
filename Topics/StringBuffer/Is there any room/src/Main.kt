import java.lang.StringBuilder

fun calculateRoom(buffer: StringBuffer) = buffer.capacity() - buffer.length

fun main() {
    val buffer = StringBuffer("Hello, Kotlin!")
    val remainingRoom = calculateRoom(buffer)
    println("Remaining room in the buffer: $remainingRoom")

    buffer.append(" This is Hyperskill!")
    val newRemainingRoom = calculateRoom(buffer)
    println("Updated remaining room in the buffer: $newRemainingRoom")
}