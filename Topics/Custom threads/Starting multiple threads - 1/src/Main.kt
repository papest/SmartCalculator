fun main() {
    WorkerThread("worker-1").start()
    WorkerThread("worker-2").start()
}

class WorkerThread(name: String) : Thread(name) {
    val numberOfLines = 3

    override fun run() {
        val name = currentThread().name

        if (!name.startsWith("worker-")) {
            return
        }

        for (i in 0 until numberOfLines) {
            println("do something...")
        }
    }
}