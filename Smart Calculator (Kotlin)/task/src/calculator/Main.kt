package calculator

fun main() {

    while (with(readln()) {
            when (this) {
                "/exit" -> "Bye!"
                "" -> ""
                "/help" -> "The program calculates the sum of numbers"
                else ->
                    this.split(" ")
                        .sumOf { it.toInt() }
            }
        }.apply {
            if (this != "") println(this)
        } != "Bye!") {
    }
}
