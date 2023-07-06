fun main() {
    val list = readln().split(" ")
    println(list.filter { it == "red" || it == "blue" })
}