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

fun printNode(node: LinkedNode?) {
    var currentNode = node
    while (currentNode != null) {
        println(currentNode?.value)
        currentNode = currentNode?.next
    }
}