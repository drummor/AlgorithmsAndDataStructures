package binarytree

import java.util.Arrays


/*
  前 ：[1] [2] [4] [7] [3] [5] [6] [8]
       ↑   \       /   \           /
      Root    left          right

  中 ：[4] [7] [2] [1] [5] [3] [8] [6]
       \       /   ↑    \          /
         left     Root       right
 */
fun rebuildTree(
    preArray: IntArray,
    midArray: IntArray,
): TreeNode? {
    println("preArray${preArray.contentToString()}")
    println("midArray${midArray.contentToString()}")
    if (preArray.isEmpty() || midArray.isEmpty()) {
        return null
    }
    val node = TreeNode(preArray[0])
    for (i in midArray.indices) {
        if (midArray[i] == node.value) {
            node.left = rebuildTree(
                preArray.copyOfRange(1, i + 1), //i+1 长度
                midArray.copyOfRange(0, i)
            )
            node.right = rebuildTree(
                preArray.copyOfRange(i + 1, preArray.size),
                midArray.copyOfRange(i + 1, midArray.size)
            )
        }
    }
    return node;
}

fun main() {
    val tree = buildTreeNode()
    val preArray = preTraversal(tree)

    val midArray = midTraversal(tree)
    println("重建前 前序 ${preArray.contentToString()}")
    println("重建前 中序 ${midArray.contentToString()}")
    val after = rebuildTree(preArray, midArray)

    println("重建前 前序 ${preTraversal(after).contentToString()}")
    println("重建前 中序 ${midTraversal(after).contentToString()}")

}