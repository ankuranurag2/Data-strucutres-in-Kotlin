package ds

/**
 * Created by ankur on 12/08/20
 */
private class BinarySearchTree {

    private inner class Node(val data: Int) {
        var left: Node? = null
        var right: Node? = null
    }

    private var rootNode: Node? = null

    fun insert(data: Int) {
        val newNode = Node(data)
        if (rootNode == null) {
            rootNode = newNode
        } else {
            var currentNode = rootNode
            while (true) {
                if (newNode.data < currentNode!!.data) {
                    if (currentNode.left == null) {
                        currentNode.left = newNode
                        return
                    }
                    currentNode = currentNode.left
                } else {
                    if (currentNode.right == null) {
                        currentNode.right = newNode
                        return
                    }
                    currentNode = currentNode.right
                }
            }
        }
    }

    fun search(data: Int): Boolean {
        if (rootNode == null)
            return false

        var currentNode = rootNode
        while (currentNode != null) {
            if (data < currentNode.data)
                currentNode = currentNode.left
            else if (data > currentNode.data)
                currentNode = currentNode.right
            else if (data == currentNode.data)
                return true
        }
        return false
    }
}


//Driver Code
fun main() {
    val bst=BinarySearchTree()

    bst.insert(10)
    bst.insert(20)
    bst.insert(5)
    bst.insert(0)
    bst.insert(40)

    println("Is 5 present : ${bst.search(5)}")
    println("Is 15 present : ${bst.search(15)}")
    println("Is 40 present : ${bst.search(40)}")
    println("Is 0 present : ${bst.search(0)}")
    println("Is 100 present : ${bst.search(100)}")
}