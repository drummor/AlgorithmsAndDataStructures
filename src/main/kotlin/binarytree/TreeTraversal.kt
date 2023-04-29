package binarytree


import java.util.Stack


/**
 *      0
 *    /   \
 *   1     2
 *  / \   / \
 *  3  4  5  6
 */
fun preTraversal(root: TreeNode?) {
    if (root == null) {
        return
    }
    val stack = Stack<TreeNode>()
    var currentNode = root
    while (stack.isEmpty().not() || currentNode != null) {
        if (currentNode != null) {
            println(currentNode.value)
            stack.push(currentNode)
            currentNode = currentNode.left
        } else {
            currentNode = stack.pop().right
        }
    }
}


/**
 *      0
 *    /   \
 *   1     2
 *  / \   / \
 *  3  4  5  6
 */
fun midTraversal(root: TreeNode?) {
    if (root == null) {
        return
    }
    val stack = Stack<TreeNode>()
    var currentNode = root
    while (stack.isEmpty().not() || currentNode != null) {
        if (currentNode != null) {
            stack.push(currentNode)
            currentNode = currentNode.left
        } else {
            currentNode = stack.pop()
            println(currentNode.value)
            currentNode = currentNode.right
        }
    }
}

/**
 *      0
 *    /   \
 *   1     2
 *  / \   / \
 *  3  4  5  6
 */
fun postTraversal(root: TreeNode?) {
    if (root == null) {
        return
    }
    var currentNode = root
    val stack = Stack<TreeNode>()
    var last: TreeNode? = null
    while (stack.isEmpty().not() || currentNode != null) {
        if (currentNode != null) {
            stack.push(currentNode)
            currentNode = currentNode.left
        } else {
            currentNode = stack.peek()
            if (currentNode.right != null && currentNode.right != last) {
                currentNode = currentNode.right
            } else {
                currentNode = stack.pop()
                println(currentNode.value)
                last = currentNode
                currentNode = null
            }
        }
    }
}

/**
 *      0
 *    /   \
 *   1     2
 *  / \   / \
 *  3  4  5  6
 */
fun postTraversal2(root: TreeNode?) {

    val resultStack = Stack<TreeNode>()
    val stack = Stack<TreeNode>()
    var currentNode = root
    while (!stack.isEmpty() || currentNode != null) {
        if (currentNode != null) {
            stack.push(currentNode)
            resultStack.push(currentNode)
            currentNode = currentNode.right
        } else {
            currentNode = stack.pop().left
        }
    }
    while (resultStack.empty().not()) {
        println(resultStack.pop().value)
    }
}


fun main() {
    postTraversal2(buildTreeNode())
}