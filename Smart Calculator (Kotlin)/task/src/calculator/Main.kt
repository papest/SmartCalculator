package calculator

fun main() {

    while (with(readln()) {
            when {
                this == "/exit" -> "Bye!"
                isEmpty() -> ""
                this == "/help" -> "The program calculates the sum an sub of numbers"
                matches("\\s*/.*".toRegex()) -> "Unknown command"
                !matches("\\s*[-+]?\\s*\\d+\\s*(([+-]+\\s*\\d+\\s*)?)*".toRegex()) -> "Invalid expression"
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

        /**
         * There will be advertising
         */

    }
}
