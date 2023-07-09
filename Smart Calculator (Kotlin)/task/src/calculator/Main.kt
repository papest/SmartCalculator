package calculator

import java.math.BigInteger
import kotlin.reflect.KFunction2
import java.util.regex.Pattern as P

fun main() {

    while (with(readln().replace(" ", "")) {
            try {
                when {
                    isEmpty() -> ""
                    matches("(.*[a-zA-Z]+\\d+.*)|(.*\\d+[a-zA-Z]+.*)".toRegex()) -> "Invalid identifier"
                    matches("/.*".toRegex()) -> command(this)
                    matches("[a-zA-Z]+=.*".toRegex()) -> assigment(this)
                    else -> expression(this)
                }
            } catch (e: Exception) {
                e.message
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
    val innerParentheses: P = P.compile("\\([^()]+\\)")
    var matcher = innerParentheses.matcher(s)
    var str = s
    return with(str) {
        when {
            checkBraces(this) -> throw Exception("Invalid expression")
            contains("(") -> {
                str = this
                while (str.contains("(")) {
                    matcher.find()
                    str = str.replaceFirst(
                        "\\([^()]+\\)".toRegex(),
                        expression(matcher.group(0).replace("(", "").replace(")", ""))
                    )
                    matcher = innerParentheses.matcher(str)
                }
                expression(str)
            }
            !matches("[-+]?(\\d+|[a-zA-Z]+)+(((([*/][-]*)|[+-]+)(\\d+|[a-zA-Z]+))?)*".toRegex()) -> "Invalid expression"
            else -> {
                var result = s
                val validName: P = P.compile("[a-zA-z]+")
                matcher = validName.matcher(result)
                while (matcher.find()) {
                    if (variables.contains(matcher.group(0))) {
                        result = result.replaceFirst(matcher.group(0), variables[matcher.group(0)].toString())
                        matcher = validName.matcher(result)
                    } else {
                        throw Exception("Unknown variable")
                    }
                }
                result = result.replace("(--)+".toRegex(), "+")
                    .replace("\\++".toRegex(), "+")
                    .replace("\\+-|-\\+".toRegex(), "-")
                result = matchingAndCounting(
                    "\\d+[*/][-]*\\d+",
                    { exp: String -> if (exp.contains("*")) BigInteger::multiply else BigInteger::div },
                    result,
                    "[*/]"
                )
                result = result.replace("\\+-|-\\+".toRegex(), "-")
                result = matchingAndCounting(
                    "[-]*\\d+[+-]\\d+",
                    { exp: String -> if (exp.matches("[-]*\\d+[+]\\d+".toRegex())) BigInteger::add else BigInteger::subtract },
                    result,
                    "([+]|((?<=\\d)-))"
                )
                result
            }
        }

    }
}

fun checkBraces(s: String): Boolean {
    if (s.count { it == '(' } != s.count { it == ')' }) return true
    var str = s
    while (str.replace("\\([^()]+\\)".toRegex(), "") != str) {
        str = str.replace("\\([^()]+\\)".toRegex(), "")
    }
    return str.count { it == ')' } > 0
}

val variables = mutableMapOf<String, String>()
fun assigment(s: String): String {
    return with(s) {
        val pos = indexOf('=')
        val name = substring(0, pos)
        if (length > pos + 1) {
            expression(substring(pos + 1))
                .run {

                    if (matches("-?\\d+".toRegex())) {
                        variables[name] = this
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
    "/help" -> "The program calculates any expression"
    else -> "Unknown command"
}

fun matchingAndCounting(
    matchString: String,
    operation: (String) -> KFunction2<BigInteger, BigInteger, BigInteger> = { exp: String ->
        if (exp.contains("*")) BigInteger::multiply else BigInteger::div
    },
    expr: String,
    ops: String
): String {
    val pattern: P = P.compile(matchString)
    var result = expr
    var matcher = pattern.matcher(result)
    while (matcher.find()) {
        val expr = matcher.group(0)
        val op = operation(expr)
        result = result.replaceFirst(
            expr, op(
                BigInteger(expr.split(ops.toRegex())[0]),
                BigInteger(expr.split(ops.toRegex())[1])
            ).toString()
        )
        matcher = pattern.matcher(result)
    }
    return result
}
