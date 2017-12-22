package Chapter04._05_validate_bst

import CtCILibrary.TreeNode

object SolutionMinMax {

    @JvmStatic
    fun main(args: Array<String>) {
        val nodes = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val root = TreeNode.createMinimalBST(nodes)
        root?.print()
        println("Tree is BST: ${isBST(root)}")
    }

    fun isBST(n: TreeNode?, min: Int? = null, max: Int? = null): Boolean {
        if (n == null) {
            return true
        }

        if ((min != null && n.data <= min) || (max != null && n.data > max)) {
            return false
        }

        if (!isBST(n.left, min, n.data) || !isBST(n.right, n.data, max)) {
            return false
        }
        return true
    }
}