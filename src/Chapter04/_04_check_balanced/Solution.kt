package Chapter04._04_check_balanced

import CtCILibrary.TreeNode
import java.util.*

object Solution {
    @JvmStatic
    fun main(args: Array<String>) {
        // Create balanced tree
        val nodes = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val tree = TreeNode.createMinimalBST(nodes)
        println("Root is: ${tree?.data}")
        println("Tree is balanced: ${isBalanced(tree)}")
        println("Tree: $tree")

        // Could be balanced, actually, but it's very unlikely...
        val unbalanced = TreeNode(10)
        for (i in 0 until 10) {
            unbalanced.insertInOrder(Random().nextInt(100))
        }
        println("Root is: ${unbalanced.height}")
        println("Tree is balanced: ${isBalanced(unbalanced)}")
        println("Tree: $tree")
    }

    private fun isBalanced(root: TreeNode?): Boolean {
        return root?.let {
            Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right)
        } ?: true
    }

    private fun getHeight(tree: TreeNode?) = tree?.height ?: 0
}