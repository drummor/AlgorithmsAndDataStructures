package arrary

import java.util.*

//丑数相关
fun solution(n: Int): Int {
    val set = HashSet<Int>()
    val priorityQueue = PriorityQueue<Int>()
    val promise = intArrayOf(2, 3, 5)

    var current = 1
    priorityQueue.offer(current)
    set.add(current)
    for (i in 0 until n) {
        current = priorityQueue.poll()
        promise.forEach {
            val t = current * it
            if (set.contains(t).not()) {
                set.add(t)
                priorityQueue.add(t)
            }
        }
    }
    return current
}

fun isUgly(n: Int): Boolean {
    var tmp = n
    while (tmp % 2 == 0) {
        tmp /= 2
    }

    while (tmp % 3 == 0) {
        tmp /= 3
    }
    while (tmp % 5 == 0) {
        tmp /= 5
    }
    return tmp == 1
}

fun main() {
    println("isUgly${isUgly(18)}")
}