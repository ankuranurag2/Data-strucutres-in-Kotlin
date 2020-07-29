package ds

/**
 * Created by ankur on 20/07/20
 */

class MyLinkedList {

    private var head: Node? = null
    private var tail: Node? = null
    private var length: Int = 0

    private inner class Node(val data: Any) {
        var nextNode: Node? = null
    }

    fun prepend(value: Any) {
        val newNode = Node(value)
        newNode.nextNode = head
        if (head == null)
            tail = newNode
        head = newNode
        length++
    }

    fun append(value: Any) {
        val newNode = Node(value)
        if (head == null)
            head = newNode
        else {
            var current = head
            while (current?.nextNode != null)
                current = current.nextNode
            current?.nextNode = newNode
        }
        tail = newNode
        length++
    }

    fun add(index: Int, value: Any) {
        when {
            index > length || index < 0 -> throw IndexOutOfBoundsException()
            index == 0 -> prepend(value)
            index == length -> append(value)
            else -> {
                var prev = head
                var counter = 0
                while (counter != index - 1) {
                    prev = prev?.nextNode
                    counter++
                }
                val newNode = Node(value)
                prev?.nextNode = newNode
                length++
            }
        }
    }

    fun get(index: Int): Any {
        if (index < 0 || index >= length) throw IndexOutOfBoundsException()
        var current = head
        var counter = 0
        while (counter != index) {
            current = current?.nextNode
            counter++
        }
        return current!!.data
    }

    fun remove(index: Int) {
        if (index < 0 || index >= length) throw IndexOutOfBoundsException()
        if (index == 0) {
            val next = head?.nextNode
            head = next
        } else {
            var counter = 0
            var current = head
            var prev: Node? = null
            while (counter != index) {
                prev = current
                current = current?.nextNode
                counter++
            }
            prev?.nextNode = current?.nextNode
            if (index == length - 1)
                tail = prev
        }
        length--
    }

    fun reverse() {
        tail = head
        var prev: Node? = null
        var current: Node? = head

        while (current != null) {
            val next = current.nextNode
            current.nextNode = prev
            prev = current
            current = next
        }
        head = prev
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
}

fun main() {
    val myLinkedList = MyLinkedList()

    myLinkedList.append(20)
    myLinkedList.append(30)
    myLinkedList.prepend(10)
    myLinkedList.printAll()

    myLinkedList.reverse()
    myLinkedList.append(0)
    myLinkedList.append('#')
    myLinkedList.prepend(40)
    myLinkedList.prepend("#")

    myLinkedList.printAll()
    myLinkedList.reverse()
    myLinkedList.printAll()


//    myLinkedList.add(3, 50)
//    myLinkedList.add(4, 60)
//    myLinkedList.printAll()
//
//    println(myLinkedList.get(3))
//    myLinkedList.remove(4)
//    myLinkedList.printAll()
//    myLinkedList.remove(3)
//    myLinkedList.printAll()

}