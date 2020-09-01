package sorting

/**
 * Created by ankur on 01/09/20
 */

fun main() {
    val intArray = intArrayOf(10, 15, 12, 5, 2, 3, 99)
//    val intArray = intArrayOf(1,2,4,5,6,7)

    var swapped = true              //to handle already sorted array
    while (swapped) {
        swapped = false
        for (i in 0 until  intArray.size-1) {
            if (intArray[i] > intArray[i + 1]) {
                val temp = intArray[i + 1]
                intArray[i + 1] = intArray[i]
                intArray[i] = temp

                swapped = true
            }
        }
    }

    println("After sorting : ${intArray.joinToString()}")
}