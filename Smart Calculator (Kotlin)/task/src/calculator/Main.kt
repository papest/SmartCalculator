package calculator

fun main() {

    while (with(readln()) {
            when (this) {
                "/exit" -> "Bye!"
                "" -> ""
                "/help" -> "The program calculates the sum an sub of numbers"
                else ->
                    replace("+", "")
                        .replace("--", "")
                        .replace("^\\s+".toRegex(), "")
                        .replace("-\\s+".toRegex(), "-")
                        .split("\\s+".toRegex())
                        .sumOf { it.toInt() }
            }
        }.apply {
            if (this != "") println(this)
        } != "Bye!") {
    }
}
