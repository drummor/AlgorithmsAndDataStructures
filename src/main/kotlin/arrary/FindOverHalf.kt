package arrary


fun findOverHalf(array: IntArray): Int {
    var condition = -1
    var count = 0
    for (i in array) {
        if (count == 0) {
            condition = i
            count++
        } else {
            if (condition == i) {
                count++
            } else {
                count--
            }
        }
    }
    return condition
}

fun findRepeatNumber(array: IntArray): Int {
    val map = IntArray(array.size)
    for (i in array.indices) {
        map[array[i]] = map[array[i]] + 1
        if (map[array[i]] > 1) {
            return array[array[i]]
        }
    }

    return -1
}

fun findRepeatWithNoSpace(array: IntArray):Int {
    var left = 1
    var right = array.size - 1

    while (left < right) {
        var count = 0
        val mid = (left + right) / 2
        for (i in array) {
            if (array[i] in left..mid) {
                count++
            }
        }
        if (count > (mid - left) + 1) {
            right = mid - 1
        } else {
            left = mid + 1
        }
    }
    return left
}



fun main() {
    val array = intArrayOf(0, 1, 2, 3, 3, 4, 5, 6, 1)
    println(findRepeatWithNoSpace(array))
}