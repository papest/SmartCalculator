package calculator

fun main() {

    while (with(readln()) {
            when (this) {
                "/exit" -> "Bye!"
                "" -> ""
                else ->
                    this.split(" ")
                        .sumOf { it.toInt() }
            }
        }.apply {
            if (this != "") println(this)
        } != "Bye!") {
    }
}
