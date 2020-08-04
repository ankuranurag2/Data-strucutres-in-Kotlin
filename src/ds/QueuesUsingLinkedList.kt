package ds

/**
 * Created by ankur on 04/08/20
 */

private class QueuesUsingLinkedList {

    private inner class Node(var data: Any) {
        var nextNode: Node? = null
    }

    private var first: Node? = null
    private var last: Node? = null
    private var length = 0

    fun enqueue(data: Any) {
        val newNode = Node(data)
        if (length == 0)
            first = newNode
        else
            last?.nextNode = newNode
        last = newNode
        length++
    }

    fun dequeue(): Any? {
        if (length == 0)
            return null
        if (first == last)
            last = null
        val node = first
        first = first?.nextNode
        length--

        return node?.data
    }

    fun peek(): Any? = first?.data

    fun printAll() {
        print("[")

        var current = first
        while (current != null) {
            print("${current.data} ")
            current = current.nextNode
        }
        print("]")
        println()
    }
}


//Driver code
fun main() {
    val queue=QueuesUsingLinkedList()

    queue.enqueue(10)
    queue.enqueue(20)
    queue.enqueue(30)
    queue.enqueue("Forty")
    queue.printAll()
    println("Dequeue : ${queue.dequeue()}")
    println("Dequeue : ${queue.dequeue()}")
    println("Dequeue : ${queue.dequeue()}")
    println("Dequeue : ${queue.dequeue()}")
    println("Dequeue : ${queue.dequeue()}")
    println("Dequeue : ${queue.dequeue()}")

    queue.enqueue('A')
    queue.enqueue('B')
    queue.enqueue('D')
    println("Peek : ${queue.peek()}")
    queue.dequeue()
    queue.enqueue("C")
    println("Peek : ${queue.peek()}")

    queue.printAll()
}