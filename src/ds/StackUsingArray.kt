package ds

/**
 * Created by ankur on 01/08/20
 */

private class StackUsingArray {
    private val THRESHOLD = 2

    private var capacity = 5
    private var items = Array<Any?>(capacity) { null }
    private var length = 0

    fun push(data: Any) {
        if (length == capacity) {
            capacity *= THRESHOLD
            val tempArray = Array<Any?>(capacity) { null }
            items = items.copyInto(tempArray)
        }
        items[length] = data
        length++
    }

    fun pop(): Any? {
        if (length == 0)
            return null
        val item = items[length-1]
        items[length-1] = null
        length--
        return item
    }

    fun peek(): Any? {
        return if (length == 0)
            null
        else
            items[length-1]
    }

    fun printAll() {
        println("[")
        for (i in (length-1) downTo 0)
            println(items[i])
        println("]")
        println()
    }
}


fun main() {
    val myStack = StackUsingArray()

    println(myStack.pop())
    println(myStack.peek())

    myStack.push(10)
    myStack.push(20)
    myStack.push(30)
    myStack.push("Forty")

    myStack.printAll()
    println("Pop : ${myStack.pop()}")
    println("Peek : ${myStack.peek()}")

    myStack.push(40)
    myStack.push(50)
    myStack.push(60)
    myStack.push(70)
    println("Pop : ${myStack.pop()}")
    println("Pop : ${myStack.pop()}")
    println("Pop : ${myStack.pop()}")
    println("Pop : ${myStack.pop()}")
    myStack.printAll()
}