package ds

/**
 * Created by ankur on 29/07/20
 */

class MyDoublyLinkedList {

    private inner class Node(val data: Any) {
        var nextNode: Node? = null
        var prevNode: Node? = null
    }

    private var head: Node? = null
    private var tail: Node? = null
    private var length = 0

    fun append(data: Any) {
        val newNode = Node(data)
        newNode.nextNode = null
        if (head == null) {
            newNode.prevNode = null
            head = newNode
        } else {
            var current = head
            while (current?.nextNode != null)
                current = current.nextNode

            current?.nextNode = newNode
            newNode.prevNode = current
        }
        tail = newNode
        length++
    }

    fun prepend(data: Any) {
        val newNode = Node(data)
        newNode.prevNode = null
        if (head == null)
            newNode.nextNode = null
        else {
            head?.prevNode = newNode
            newNode.nextNode = head
        }

        head = newNode
        length++
    }

    fun add(index: Int, data: Any) {
        when {
            index < 0 || index > length -> throw IndexOutOfBoundsException()
            index == 0 -> prepend(data)
            index == length -> append(data)
            else -> {
                var count = 0
                var next = head
                var prev: Node? = null
                while (count != index) {
                    prev = next
                    next = next?.nextNode
                    count++
                }
                val newNode = Node(data)
                next?.prevNode = newNode
                newNode.nextNode = next
                newNode.prevNode = prev
                prev?.nextNode = newNode

                length++
            }
        }
    }

    fun get(index: Int): Any {
        if (index < 0 || index >= length)
            throw IndexOutOfBoundsException()
        else {
            var count = 0
            var node = head
            while (count != index) {
                node = node?.nextNode
                count++
            }
            return node?.data ?: -1
        }
    }

    fun remove(index: Int) {
        if (index < 0 || index >= length) throw IndexOutOfBoundsException()

        if (index == 0) {
            val nextNode = head?.nextNode
            nextNode?.prevNode = null
            head = nextNode
        } else if (index == length - 1) {
            val prevNode = tail?.prevNode
            prevNode?.nextNode = null
            tail = prevNode
        } else {
            var count = 0
            var node = head
            while (count != index) {
                node = node?.nextNode
                count++
            }
            val prevNode = node?.prevNode
            val nextNode = node?.nextNode
            prevNode?.nextNode = nextNode
            nextNode?.prevNode = prevNode
        }
        length--
    }

    fun printAll() {
        var current = head
        while (current?.nextNode != null) {
            print("${current.data} ")
            current = current.nextNode
        }
        print(current?.data)
        println()
    }

    fun reversePrint() {
        var current = tail
        while (current?.prevNode != null) {
            print("${current.data} ")
            current = current.prevNode
        }
        print(current?.data)
        println()
    }
}

fun main() {
    val doublyLL = MyDoublyLinkedList()

    doublyLL.append(10)
    doublyLL.append(20)
    doublyLL.prepend("B")
    doublyLL.prepend("A")
    doublyLL.add(2, 'C')
    doublyLL.add(3, 0)

    doublyLL.printAll()
    doublyLL.reversePrint()

    println(doublyLL.get(3))
    println(doublyLL.get(0))
    println(doublyLL.get(5))

    doublyLL.remove(5)
    doublyLL.remove(3)
    doublyLL.printAll()
}