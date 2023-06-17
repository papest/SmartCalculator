import kotlin.random.Random
@Suppress("All")
fun makeDecision(): String {
    val decision = arrayOf("Rock", "Paper", "Scissors")
    return decision[Random.nextInt(0, 3)]
}