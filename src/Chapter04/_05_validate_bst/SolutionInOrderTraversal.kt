package Chapter04._05_validate_bst

import CtCILibrary.TreeNode

object SolutionInOrderTraversal {
    private var lastInt: Int? = null

    @JvmStatic
    fun main(args: Array<String>) {
        val nodes = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val root = TreeNode.Companion.createMinimalBST(nodes)

        println("Tree is BST: ${isBST(root)}")

        test()
    }

    private fun isBST(root: TreeNode?): Boolean {
        if (root == null) return true

        if (!isBST(root.left)) {
            return false
        }

        //check current
        if (lastInt != null && root.data <= lastInt!!) {
            return false
        }
        lastInt = root.data

        //check / recurse right
        if (!isBST(root.right)) {
            return false
        }

        return true
    }

    private fun test() {
        var node: TreeNode?
        var condition: Boolean
        println("test cases for equals condition.")

        /* Expect true: for left child: node.data <= last_printed.
                   2
                  / \
                /    \
               2      3
                       \
                        4
		*/
        val array2 = intArrayOf(1, 2, 3, 4)
        node = TreeNode.createMinimalBST(array2)
        node?.left?.data = 2
        node?.print()
        lastInt = null
        condition = isBST(node)
        println("should be true: " + condition)

        /* Expect false: for right child: node.data <= last_printed.
                          2
                         / \
                       /    \
                      1      2
                              \
                               4
		 */
        val array3 = intArrayOf(1, 2, 3, 4)
        node = TreeNode.createMinimalBST(array3)
        node?.right?.data = 2
        node?.print()
        lastInt = null
        condition = isBST(node)
        println("should be false: " + condition)
    }
}