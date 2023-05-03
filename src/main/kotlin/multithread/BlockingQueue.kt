package multithread

import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.thread

class BlockingQueue<T>(var capacity: Int) {

    private val list = ArrayList<T>()

    private val lock = ReentrantLock()
    private val condition = lock.newCondition();

    fun offer(e: T) {
        lock.lock()
        try {
            while (list.size >= capacity) {
                condition.await()
            }
            list.add(e)
            condition.signalAll()
        } finally {
            lock.unlock()
        }
    }

    fun take(): T {
        lock.lock()
        try {
            while (list.isEmpty()) {
                condition.await()
            }
            condition.signalAll()
            return list.removeFirst()
        } finally {
            lock.unlock()
        }
    }
}

suspend fun main() {
    val blockingQueue = BlockingQueue<Int>(1)
    thread {
        repeat(100) {
            blockingQueue.offer(it)
        }
    }

    thread {
        repeat(100) {
            println(blockingQueue.take())
        }
    }
}