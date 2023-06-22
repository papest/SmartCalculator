package calculator

import java.util.regex.Pattern as P

fun main() {

    while (with(readln().replace(" ", "")) {
            when {
                isEmpty() -> ""
                matches("(([a-zA-Z]+\\d+.*)|(\\d+[a-zA-Z]+.*))".toRegex()) -> "Invalid identifier"
                matches("/.*".toRegex()) -> command(this)
                matches("[a-zA-Z]+=.*".toRegex()) -> assigment(this)
                else -> expression(this)
            }
        }.apply {
            if (this != "") println(this)
        } != "Bye!") {

        /**
         * There will be advertising
         */

    }
}

fun expression(s: String): String {
    return with(s) {
        when {
            matches("(\\d+[a-zA-Z]+.*) | ([a-zA-Z]+\\d+.*)".toRegex()) -> "Invalid identifier"
            !matches("[-+]?(\\d+|[a-zA-Z]+)+(([+-]+(\\d+|[a-zA-Z]+))?)*".toRegex()) -> "Invalid expression"
            else -> {
                var result = s
                val validName: P = P.compile("[a-zA-z]+")
                var matcher = validName.matcher(result)
                while (matcher.find()) {
                    if (variables.contains(matcher.group(0))) {
                        result = result.replaceFirst(matcher.group(0), variables[matcher.group(0)].toString())
                        matcher = validName.matcher(result)

                    } else {
                        return "Unknown variable"

                    }
                }
                result = result.replace("(--)+".toRegex(), "+")
                    .replace("\\++".toRegex(), "+")
                    .replace("\\+-|-\\+".toRegex(), "-")
                    .replace("\\+".toRegex(), " ")
                    .replace("(?<=\\d)-".toRegex(), " -")
                    .split(" ")
                    .sumOf { it.toInt() }.toString()
                result
            }
        }

    }
}

val variables = mutableMapOf<String, Int>()
fun assigment(s: String): String {
    return with(s) {
        val pos = indexOf('=')
        val name = substring(0, pos)
        if (length > pos + 1) {
            expression(substring(pos + 1))
                .run {

                    if (matches("-?\\d+".toRegex())) {
                        variables[name] = this.toInt()
                        ""
                    } else {
                        "Invalid assigment"
                    }
                }
        } else {
            "Invalid assigment"
        }
    }
}

fun command(s: String): String = when (s) {
    "/exit" -> "Bye!"
    "/help" -> "The program calculates the sum an sub of numbers"
    else -> "Unknown command"
}
