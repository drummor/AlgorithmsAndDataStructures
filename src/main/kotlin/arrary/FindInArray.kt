package arrary


//查找最小的连续满足给定target的子数组长度
fun findMinArray(array: IntArray, target: Int): Int {
    var start = 0
    var end = 0
    var sum = 0
    var range = Int.MAX_VALUE
    while (end < array.size) {
        sum += array[end]
        while (sum >= target && start <= end) {
            range = Math.min(range, end - start + 1)
            sum -= array[start]
            start++
        }
        end++
    }
    return range
}

fun main() {
    val array = intArrayOf(1, 2, 1, 6, 1, 5, 2)
    println(findMinArray(array, 8))
}