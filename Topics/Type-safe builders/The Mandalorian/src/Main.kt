data class Ship(val name: String, val ammunition: Int)

class ShipBuilder {
    var name = ""
    var ammunition = 0

    fun name(value: String) {
        name = value
    }

    fun ammunition(value: Int) {
        ammunition = value
    }

    fun build() = Ship(name, ammunition)

}

fun buildShip(block: ShipBuilder.() -> Unit): Ship {
    val builder = ShipBuilder()
    builder.block()
    return builder.build()
}