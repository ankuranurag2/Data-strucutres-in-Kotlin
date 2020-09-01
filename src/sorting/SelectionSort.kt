package sorting

/**
 * Created by ankur on 01/09/20
 */

fun main() {
    val intArray = intArrayOf(100, 10, 15, 12, 5, 2, 3, 99)

    for (i in intArray.indices) {
        var minIndex = i
        for (j in i + 1 until intArray.size)
            if (intArray[j] < intArray[minIndex])
                minIndex = j

        if (i != minIndex) {
            val temp = intArray[minIndex]
            intArray[minIndex] = intArray[i]
            intArray[i] = temp
        }
    }

    println("After sorting : ${intArray.joinToString()}")
}