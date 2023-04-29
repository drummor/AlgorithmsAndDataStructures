package binarytree

class TreeNode(val value: Int = 0, var left: TreeNode? = null, var right: TreeNode? = null)

/**
 *      0
 *    /   \
 *   1     2
 *  / \   / \
 *  3  4  5  6
 */
fun buildTreeNode(): TreeNode {
    val node0 = TreeNode(0, null, null)
    val node1 = TreeNode(1, null, null)
    val node2 = TreeNode(2, null, null)
    val node3 = TreeNode(3, null, null)
    val node4 = TreeNode(4, null, null)
    val node5 = TreeNode(5, null, null)
    val node6 = TreeNode(6, null, null)

    node0.left = node1
    node0.right = node2
    node1.left = node3
    node1.right = node4
    node2.left = node5
    node2.right = node6
    return node0
}