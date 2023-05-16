package binarytree

/*
  判断是否为树的子结构
 */
fun isSubTree(node: TreeNode?, node2: TreeNode): Boolean {

    //两个结构无论谁为空 谁也不是谁的子结构
    if (node == null || node2 == null) {

        val set = HashSet<String>()
        return false
    }

    //先判断根是不是一致的
    if (isQualified(node, node2)) {
        return true
    }

    //拿左边和右边分别对比
    return isSubTree(node?.left, node2) || isSubTree(node.right, node2)

}

//判断的是两个树结构是不是一致的
fun isQualified(r1: TreeNode?, r2: TreeNode?): Boolean {
    //子树先到底了
    if (r2 == null) {
        return true
    }
    //父树到底了
    if (r1 == null) {
        return false
    }

    //当前节点本身不相同
    if (r1.value != r2.value) {
        return false
    }

    //左右都相同
    return isQualified(r1.left, r2.left) && isQualified(r1.right, r2.right)
}
