package binarytree

class MaxDistance {

    fun maxDistance(root: TreeNode): Int {
        return max.coerceAtLeast(fetchMaxDistance(root))
    }

    var max = 0
    fun fetchMaxDistance(node: TreeNode): Int {
        if (node == null) {
            return 0
        }

        var leftMax = 0
        var rightMax = 0;
        if (node.left != null) {
            leftMax = fetchMaxDistance(node.left!!)
        }
        if (node.right != null) {
            rightMax = fetchMaxDistance(node.right!!)
        }
        max = (leftMax + rightMax).coerceAtLeast(max)
        return leftMax.coerceAtLeast(rightMax) + 1


    }
}