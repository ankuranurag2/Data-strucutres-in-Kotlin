package ds

/**
 * Created by ankur on 19/07/20
 */

class MyHashMap {

    private val CAPACITY = 50
    private val items = Array(CAPACITY) { Array<String>(2) { "" } }

    private fun getHashCode(key: String): Int {
        var hashCode = 149
        key.forEachIndexed { index: Int, char ->
            hashCode = ((hashCode + char.toInt()) * index) % CAPACITY
        }
        return hashCode
    }

    fun put(key: String, value: String) {
        val hashCode = getHashCode(key)
        items[hashCode] = arrayOf(key, value)
    }

    fun get(key: String): Array<String> {
        val hashCode = getHashCode(key)
        return items[hashCode]
    }

    fun size() = items.size

    fun keys():List<String>{
        val keys=ArrayList<String>()
        items.forEach {
            val key=it[0]
            if (!key.isNullOrBlank())
                keys.add(key)
        }
        return keys
    }
}

fun main() {

    val map = MyHashMap()

    map.put("name", "ankur")
    map.put("job", "developer")
    map.put("exp", "3")
    map.put("exp", "5")

    println(map.get("name").joinToString())
    println(map.get("exp").joinToString())
    println(map.get("job").joinToString())

    println(map.keys().joinToString())
}