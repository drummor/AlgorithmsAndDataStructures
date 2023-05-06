package binarytree

import com.sun.tracing.dtrace.ArgsAttributes
import java.util.Stack

fun ZPrintTree(treeNode: TreeNode) {
    val oddStack = Stack<TreeNode>()
    val evenStack = Stack<TreeNode>()
    val result = ArrayList<TreeNode>()


    oddStack.push(treeNode)
    while (oddStack.isEmpty().not() || evenStack.isEmpty().not()) {

        while (oddStack.isEmpty().not()) {
            val currentNode = oddStack.pop()
            result.add(currentNode)
            if (currentNode.left != null) {
                evenStack.push(currentNode.left)
            }
            if (currentNode.right != null) {
                evenStack.push(currentNode.right)
            }
        }

        while (evenStack.isEmpty().not()) {
            val currentNode = evenStack.pop()
            result.add(currentNode)
            if (currentNode.right != null) {
                oddStack.push(currentNode.right)
            }
            if (currentNode.left != null) {
                oddStack.push(currentNode.left)
            }
        }
    }
    for (i in result.indices) {
        println(result[i].value)
    }
}


/*
换行打印
 */
fun printTreeWithLine(treeNode: TreeNode) {
    if (treeNode == null) {
        return
    }
    val stack = Stack<TreeNode>()
    val stack2 = Stack<TreeNode>()
    stack.push(treeNode)
    while (stack.isEmpty().not() || stack2.isEmpty().not()) {
        if (stack.isEmpty().not()) {
            while (stack.isEmpty().not()) {
                val current = stack.pop()
                print(current.value)
                if (current.right != null) {
                    stack2.push(current.right)
                }
                if (current.left != null) {
                    stack2.push(current.left)
                }
            }
        } else {
            while (stack2.isEmpty().not()) {
                val current = stack2.pop()
                print(current.value)
                if (current.right != null) {
                    stack.push(current.right)
                }
                if (current.left != null) {
                    stack.push(current.left)
                }
            }
        }
        println()
    }

}


fun main() {
    /**
     *      0
     *    /   \
     *   1     2
     *  / \   / \
     *  3  4  5  6
     */
    printTreeWithLine(buildTreeNode())

}