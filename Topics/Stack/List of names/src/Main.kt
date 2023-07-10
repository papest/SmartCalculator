import java.util.*

fun main() {
    val list = readln().split(" ")
    val stack = Stack<String>()
    stack.addAll(list)
    println(List(stack.size) { stack.pop() }.joinToString(" "))
}