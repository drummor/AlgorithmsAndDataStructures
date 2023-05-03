package linkedlist

import java.awt.HeadlessException


fun revertLinkedNode(node: LinkedNode?): LinkedNode? {
    if (node?.next == null) {
        return node
    }

    var head: LinkedNode? = null
    var currentNode = node
    while (currentNode != null) {
        /**
         * 重点：记录当前节点的下一个节点
         */
        val tmp = currentNode.next
        currentNode.next = head
        head = currentNode
        currentNode = tmp
    }
    return head
}

/*
放置一个虚拟头节点
 */
fun mergeNode(node1: LinkedNode?, node2: LinkedNode?): LinkedNode? {
    if (node1 == null) {
        return node2
    }
    if (node2 == null) {
        return node1
    }
    var p1 = node1
    var p2 = node2
    val newHead: LinkedNode = LinkedNode(0, null);
    var p: LinkedNode? = newHead;

    while (p1 != null && p2 != null) {
        if (p1.value < p2.value) {
            p!!.next = p1
            p1 = p1.next
        } else {
            p!!.next = p2
            p2 = p2.next
        }
        p = p.next
    }
    if (p1 == null) {
        p!!.next = p2
    }
    if (p2 == null) {
        p!!.next = p1
    }
    return newHead.next
}


/*
    连个链表的公共节点
 */
fun findCommonNode(node1: LinkedNode?, node2: LinkedNode?): LinkedNode? {

    if (node1 == null || node2 == null) {
        return null
    }
    var p1 = node1
    var p2 = node2
    var p1IsRest = false
    var p2IsRest = false

    while (p1 != p2) {
        if (p1?.next == null && p1IsRest.not()) {
            p1IsRest = true
            p1 = node2
        } else {
            p1 = p1?.next
        }
        if (p2?.next == null && p2IsRest.not()) {
            p2 = node1
            p2IsRest = true
        } else {
            p2 = p2?.next
        }
    }
    return p1
}


/*
    1.是否有环
    2.环的长度
    3.快慢指针锁定入口
 */

fun findCycleNode(node: LinkedNode?): LinkedNode? {
    if (node == null) {
        return null
    }

    var fast: LinkedNode? = node.next?.next
    var low: LinkedNode? = node.next

    while (fast != low && fast != null) {
        low = low?.next
        fast = fast?.next?.next
    }
    //无环
    if (fast == null) {
        return null
    }
    println("有环low: ${low?.value}  fast:${fast.value}")
    var cycle = 1
    fast = fast.next
    println("low 长度：${low?.value}")
    while (fast != low) {
        fast = fast?.next
        //  println("cal 长度：${fast?.value}")
        cycle++
    }
    println("环的长度$cycle")

    fast = node
    low = node
    while (cycle-- > 0) {
        fast = fast?.next
    }
    while (low != fast) {
        low = low?.next
        fast = fast?.next
    }

    return low

}


/*
   去掉重复的节点
 */
fun removeDuplication(node: LinkedNode?): LinkedNode? {
    if (node == null) {
        return node
    }
    val result = LinkedNode(0, null)
    result.next = node
    var currentNode = result.next

    while (currentNode != null) {
        if (currentNode.next != null && currentNode.next!!.next != null) {
            var tempNode = currentNode.next
            val value = tempNode!!.value
            while (tempNode!!.next != null && value == tempNode!!.next!!.value) {
                tempNode = tempNode!!.next
            }
            currentNode.next = tempNode.next
            currentNode = tempNode
        } else {
            currentNode = currentNode.next
        }
    }

    return result.next
}

fun main() {
    val node = buildLinkedNode()
    // printNode(revertLinkedNode(node))

    //printNode(buildLinkedNode0())
//    printNode(buildLinkedNode0())
//    printNode(buildLinkedNode2())
//    printNode(mergeNode(buildLinkedNode0(), buildLinkedNode2()))


    val duplicationNode = buildDuplication()
    printNode(duplicationNode)
    printNode(removeDuplication(duplicationNode))

}