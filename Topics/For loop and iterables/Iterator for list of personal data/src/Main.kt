class ListStorageIterator(private val workTeam: ListStorage) : Iterator<StoredNode> {

    lateinit var current: StoredNode

    override fun hasNext(): Boolean = !::current.isInitialized || current.next != null

    override fun next(): StoredNode {
        current = if (!::current.isInitialized) {
            workTeam.head
        } else {
            if (current.next == null) throw NoSuchElementException()
            current.next!!
        }
        return current
    }
}

@SuppressWarnings("MagicNumber")
fun main() {
    val listStorage = ListStorage(StoredNode("Nik", 30))
    listStorage.add(StoredNode("Sofi", 25))
    listStorage.add(StoredNode("Mike", 45))
    val iterStorage = listStorage.iterator()
    while (iterStorage.hasNext()) {
        println(iterStorage.next().toNodeString())
    }
}

class StoredNode(private val name: String, private val age: Int, var next: StoredNode? = null) {

    fun toNodeString(): String {
        return "Name $name age $age"
    }
}

class ListStorage(var head: StoredNode, var tail: StoredNode = head) : Iterable<StoredNode> {

    fun add(newNode: StoredNode) {
        tail.next = newNode
        tail = newNode
    }

    override fun iterator(): Iterator<StoredNode> {
        return ListStorageIterator(this)
    }
}