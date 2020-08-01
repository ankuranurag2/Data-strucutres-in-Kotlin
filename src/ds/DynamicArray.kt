package ds

/**
 * Created by ankur on 09/07/20
 */

class DynamicArray {
    private val INCREMENT_THRESHOLD = 2
    private var items = IntArray(1)
    private var capacity = 1
    private var currentSize = 0

    fun push(data: Int) {
        if (currentSize == capacity) {
            val newCapacity = (INCREMENT_THRESHOLD * capacity)
            val tempArray = IntArray(newCapacity)
            items.forEachIndexed { index, item ->
                tempArray[index] = item
            }
            capacity = newCapacity
            items = tempArray
        }
        items[currentSize] = data
        currentSize++
    }

    fun pushAtIndex(data: Int, index: Int) {
        if (index == capacity)
            push(data)
        else
            items[index] = data
    }

    fun pop() = currentSize--

    fun size() = currentSize

    fun capacity() = capacity

    fun get(index: Int) = if (index < currentSize) items[index] else throw ArrayIndexOutOfBoundsException()
}

fun main() {
    val array = DynamicArray()

    array.push(10)
    array.push(20)
    array.push(30)

    println("Size : ${array.size()}")
    println("Capacity : ${array.capacity()}")

    array.pop()
    println("Size : ${array.size()}")
    println("Capacity : ${array.capacity()}")

    array.push(30)
    array.push(40)
    array.push(50)

    println("Size : ${array.size()}")
    println("Capacity : ${array.capacity()}")
}