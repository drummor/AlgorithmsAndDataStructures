package binarytree


import java.util.Stack


/**
 *      0
 *    /   \
 *   1     2
 *  / \   / \
 *  3  4  5  6
 */
fun preTraversal(root: TreeNode?): IntArray {
    var array = IntArray(0)
    if (root == null) {
        return array
    }
    val stack = Stack<TreeNode>()
    var currentNode = root
    while (stack.isEmpty().not() || currentNode != null) {
        if (currentNode != null) {
            array = array.plus(currentNode.value)
            println(currentNode.value)
            stack.push(currentNode)
            currentNode = currentNode.left
        } else {
            currentNode = stack.pop().right
        }
    }
    return array
}


/**
 *      0
 *    /   \
 *   1     2
 *  / \   / \
 *  3  4  5  6
 */
fun midTraversal(root: TreeNode?): IntArray {
    var array = IntArray(0)
    if (root == null) {
        return array
    }
    val stack = Stack<TreeNode>()
    var currentNode = root
    while (stack.isEmpty().not() || currentNode != null) {
        if (currentNode != null) {
            stack.push(currentNode)
            currentNode = currentNode.left
        } else {
            currentNode = stack.pop()
            array = array.plus(currentNode.value)
            println(currentNode.value)
            currentNode = currentNode.right
        }
    }
    return array
}

/**
 *      0
 *    /   \
 *   1     2
 *  / \   / \
 *  3  4  5  6
 */
fun postTraversal(root: TreeNode?): IntArray {
    val array = IntArray(0)
    if (root == null) {
        return array
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
                array.plus(currentNode.value)
                println(currentNode.value)
                last = currentNode
                currentNode = null
            }
        }
    }
    return array
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

fun postTraversal3(root: TreeNode) {
    val stack = Stack<TreeNode>()
    stack.push(root)
    var prev: TreeNode? = null
    while (stack.isEmpty().not()) {
        val curr = stack.peek()
        if (prev == null || prev.left == curr || prev.right == curr) {
            if (curr.left != null) {
                stack.push(curr.left)
            } else if (curr.right != null) {
                stack.push(curr.right)
            }
        } else if (curr.left == prev) {
            if (curr.right != null) {
                stack.push(curr.right)
            }
        } else {
            println(curr.value)
            stack.pop()
        }
        prev = curr
    }
}

fun postOrderTraversal4(root: TreeNode) {
    val stack = Stack<TreeNode>()
    val result = Stack<TreeNode>()
    stack.push(root)
    while (stack.isEmpty().not()) {
        val node = stack.pop()
        result.push(node)
        if (node.left != null) {
            stack.push(node.left)
        }
        if (node.right != null) {
            stack.push(node.right)
        }
    }

    while (result.isEmpty().not()) {
        println(result.pop().value)
    }
}

// 二 叉树 的深度

fun treeNodeHeight(root: TreeNode?): Int {
    if (root == null) {
        return 0
    }
    val leftHeight = treeNodeHeight(root.left)
    val rightHeight = treeNodeHeight(root.right)
    return if (leftHeight >= rightHeight) {
        leftHeight + 1
    } else {
        rightHeight + 1
    }
}

//todo
fun nextNodeInMidTraversal(root: TreeNode?, target: Int) {


}

fun main() {
    postTraversal3(buildTreeNode())
}