import java.util.*

fun main() {
    val list = readln().split(" ").map { it.toDouble() }
    if (list.isNotEmpty()) {
        val stack = Stack<Double>()
        stack.addAll(list)
        print(stack.pop())
        while (stack.isNotEmpty()) print(" ${stack.pop()}")
    }
}