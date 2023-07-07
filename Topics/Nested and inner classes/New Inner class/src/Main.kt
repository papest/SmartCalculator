data class Vehicle(val name: String) {
    inner class Body(private var color: String) {
        fun printColor() = println("The $name vehicle has a $color body.")
    }
}