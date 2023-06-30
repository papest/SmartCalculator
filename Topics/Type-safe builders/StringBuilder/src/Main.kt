class StringBuilderWrapper {
    private val stringBuilder = StringBuilder()

    fun append(value: String) {
        stringBuilder.append(value)
    }

    fun newline() {
        stringBuilder.appendLine()
    }

    fun build(): String {
        return stringBuilder.toString()
    }
}

fun buildString(block: StringBuilderWrapper.() -> Unit): String =
    StringBuilderWrapper()
        .apply(block)
        .build()