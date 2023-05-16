package binarytree


class TreeNodeWithP {
    var value: Int = 0
    var left: TreeNodeWithP? = null
    var right: TreeNodeWithP? = null
    var parent: TreeNodeWithP? = null
}

/**
中序遍历的下一个节点

 */

fun getNextNode(target: TreeNodeWithP): TreeNodeWithP? {
    if (target == null) {
        return null
    }
    var cur: TreeNodeWithP? = null

    /**
     * 1 如果当前节点右子树不为空，则找到右子树的最左节点
     */

    if (target.right != null) {
        cur = target.right
        while (cur?.left != null) {
            cur = cur.left
        }
        return cur
    }

    /**
     * 2 若没有右节点，则判断其是否为父节点的左子树
     */

    if (target.parent == null) {
        return null
    }
    if (target == target?.parent?.left) {
        return target.parent
    }

    /**
     * 3 向上寻找父节点，找到父节点是其父节点的左子树为止。
     */

    var mTarget: TreeNodeWithP? = target

    while (mTarget?.parent != null) {
        if (mTarget == mTarget?.parent?.left) {
            return mTarget.parent
        }
        mTarget = mTarget?.parent
    }
    return null
}