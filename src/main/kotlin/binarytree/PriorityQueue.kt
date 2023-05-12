package binarytree


class PriorityQueue {
    private val data = ArrayList<Int>()
    fun offer(e: Int) {
        data.add(e)
        siftUp(data.size - 1)
    }

    fun size(): Int {
        return data.size
    }

    fun poll(): Int {
        val result = data.removeFirst()
        if (data.isEmpty().not()) {
            val e = data.removeAt(data.size - 1)
            data.add(0, e)
            siftDown(0, e)
        }
        return result
    }


    private fun siftDown(idx: Int, e: Int) {
        if (data.size <= 1) {
            return
        }
        val down = (data.size - 2) / 2
        var current = idx
        while (current <= down) {
            val left = current * 2 + 1
            val right = left + 1
            var child = left
            if (right > data.size - 1) {
                child = left
            } else if (data[left] < data[right]) {
                child = right
            } else {
                child = left
            }

            if (e < data[child]) {
                data[current] = e
                break
            }
            data[current] = data[child]
            current = child
        }
        data[current] = e
    }

    private fun siftUp(idx: Int) {
        var current = idx
        var parent = (idx - 1) / 2
        while (current > 0 && data[parent] > data[current]) {
            val tmp = data[parent]
            data[parent] = data[current]
            data[current] = tmp
            current = parent
            parent = (current - 1) / 2
        }
    }


    fun isEmpty(): Boolean {
        return data.isEmpty()
    }

    fun printQueue() {
        data.forEach {
            print("$it,")
        }
    }
}

fun main() {
    val q = PriorityQueue()
    q.offer(9)
    q.offer(6)
    q.offer(4)
    q.offer(5)

    q.offer(3)
    q.offer(2)
    q.offer(1)

    println("q.size ${q.size()}")
    while (q.isEmpty().not()) {
        print(">${q.poll()},")
    }


}