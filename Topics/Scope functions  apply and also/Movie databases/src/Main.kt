data class Movie(
    var name: String = "The Knack ...and How to Get It",
    var link: String = "https://",
    var dataBaseName: String = "IMDB"
)

fun main() {

    Movie().apply {
        readln().split(" ").let {
            dataBaseName = it[0]
            link = it[1]
        }.let { println(this) }
    }

}