@SuppressWarnings("MagicNumber")
class BankAccount {
    var balance = 0L

    fun addMoney(action: String) {
        synchronized(this) {
            when (action) {
                "1" -> addGold()

                "2" -> addSilver()

                else -> addCopper()
            }
        }
    }
    private fun addGold() {
        balance += 10000
    }
    private fun addSilver() {
        balance += 100
    }
    private fun addCopper() {
        balance += 1
    }
}