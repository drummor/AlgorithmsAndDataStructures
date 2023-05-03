package linkedlist

class LinkedNode(var value: Int, var next: LinkedNode?)

fun buildLinkedNode(): LinkedNode {
    val node1 = LinkedNode(1, null);
    val node2 = LinkedNode(2, null)
    val node3 = LinkedNode(3, null)
    val node4 = LinkedNode(4, null)
    val node5 = LinkedNode(5, null)
    val node6 = LinkedNode(6, null)

    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5
    node5.next = node6

    return node1
}

fun buildLinkedNode0(): LinkedNode {
    val node1 = LinkedNode(1, null);
    val node2 = LinkedNode(3, null)
    val node3 = LinkedNode(5, null)
    val node4 = LinkedNode(9, null)
    val node5 = LinkedNode(10, null)
    val node6 = LinkedNode(15, null)

    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5
    node5.next = node6

    return node1
}

fun buildLinkedNode2(): LinkedNode {
    val node1 = LinkedNode(2, null);
    val node2 = LinkedNode(4, null)
    val node3 = LinkedNode(6, null)
    val node4 = LinkedNode(8, null)
    val node5 = LinkedNode(17, null)
    val node6 = LinkedNode(19, null)
    val node7 = LinkedNode(20, null)
    val node8 = LinkedNode(22, null)

    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5
    node5.next = node6
    node6.next = node7
    node7.next = node8

    return node1
}


fun buildCommon1(): Array<LinkedNode> {
    val node1 = LinkedNode(0, null);
    val node2 = LinkedNode(1, null)
    val node3 = LinkedNode(2, null)
    val node4 = LinkedNode(3, null)


    val node5 = LinkedNode(17, null)
    val node6 = LinkedNode(19, null)
    val node7 = LinkedNode(20, null)
    val node8 = LinkedNode(22, null)

    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5


    val node11 = LinkedNode(10, null);
    val node21 = LinkedNode(11, null)
    val node31 = LinkedNode(12, null)
    val node41 = LinkedNode(13, null)

    node11.next = node21
    node21.next = node31
    node31.next = node41
    node41.next = node5

    node5.next = node6
    node6.next = node7
    node7.next = node8

    return arrayOf(node1, node11)
}


fun buildCycleNode(): LinkedNode {
    val node1 = LinkedNode(0, null);
    val node2 = LinkedNode(1, null)
    val node3 = LinkedNode(2, null)
    val node4 = LinkedNode(3, null)


    val node5 = LinkedNode(5, null)
    val node6 = LinkedNode(6, null)
    val node7 = LinkedNode(7, null)
    val node8 = LinkedNode(8, null)

    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5

    node5.next = node6
    node6.next = node7
    node7.next = node8
    node8.next = node5
    return node1
}


fun buildDuplication(): LinkedNode {
    val node1 = LinkedNode(0, null);
    val node2 = LinkedNode(1, null)
    val node21 = LinkedNode(1, null)
    val node22 = LinkedNode(1, null)
    val node3 = LinkedNode(2, null)
    val node4 = LinkedNode(3, null)
    val node41 = LinkedNode(3, null)
    node1.next = node2
    node2.next = node21
    node21.next = node22
    node22.next = node3
    node3.next = node4
    node4.next = node41
    return node1
}

fun printNode(node: LinkedNode?) {
    var currentNode = node
    val stringBuilder = StringBuilder()
    while (currentNode != null) {
        stringBuilder.append("->")
        stringBuilder.append(currentNode?.value)
        currentNode = currentNode?.next
    }
    println(stringBuilder.toString())
}