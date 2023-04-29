package linkedlist


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


fun main() {
    val node = buildLinkedNode()

    printNode(revertLinkedNode(node))
}