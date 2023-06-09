fun main() {
    val heroesList = mutableListOf("John Snow", "Daenerys Targaryen")
    println("Old heroes list: ${heroesList.joinToString()}")

    heroesList.apply {
        add(readln())
        println("New heroes list: ${joinToString()}")
    }
}
