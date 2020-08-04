package ds

/**
 * Created by ankur on 01/08/20
 */

private class StackUsingLinkedList {

    private inner class Node(var data: Any) {
        var next: Node? = null
    }

    private var top: Node? = null
    private var bottom: Node? = null
    private var length = 0

    fun push(data: Any) {
        val newNode = Node(data)
        if (length == 0)
            bottom = newNode
        else
            newNode.next = top

        top = newNode
        length++
    }

    fun pop(): Any? {
        if (length == 0)
            return null
        if (top == bottom)
            bottom = null
        val oldTop = top
        top = oldTop?.next
        length--
        return oldTop?.data
    }

    fun peek() = top?.data

    fun printAll() {
        var current = top
        println("[")
        while (current != null) {
            println(current.data)
            current = current.next
        }
        println("]")
        println()
    }
}

//Driver Code
fun main() {
    val myStack = StackUsingLinkedList()

    myStack.push(10)
    myStack.push(20)
    myStack.push(30)
    myStack.push("Forty")
    myStack.printAll()
    println("Pop : ${myStack.pop()}")
    println("Pop : ${myStack.pop()}")
    println("Pop : ${myStack.pop()}")
    println("Pop : ${myStack.pop()}")
    println("Pop : ${myStack.pop()}")

    myStack.printAll()
    myStack.push(40)
    println("Peek : ${myStack.peek()}")
    myStack.printAll()
}