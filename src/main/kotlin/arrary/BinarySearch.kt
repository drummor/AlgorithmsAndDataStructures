package arrary

/**
 * 二分查找
 * |1|2|3|4|5|6|7|
 * ^
 * ^
 */
fun binarySearch(array: IntArray?, target: Int): Int {

    if (array?.size == 0) {
        return -1
    }
    var end = array!!.size - 1
    var begin = 0
    var mid = (begin + end) / 2
    while (begin <= end) {
        val midValue = array!![mid]
        if (target > midValue) {
            begin = mid + 1
        } else if (target < midValue) {
            end = mid - 1
        } else {
            return mid
        }
        mid = (begin + end) / 2
    }

    return -1

}

fun main() {
    val array = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8)
    val result = binarySearch(array, 5)
    println(result)
}