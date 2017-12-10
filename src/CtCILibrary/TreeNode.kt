package CtCILibrary

/*
 * One node of a binary tree. The data element stored is a single
 * character.
 */
class TreeNode(var data: Int, var left: TreeNode? = null, var right: TreeNode? = null, var parent: TreeNode? = null) {
    companion object {
        fun createMinimalBST(array: IntArray): TreeNode? {
            return createMinimalBST(array, 0, array.size - 1)
        }

        private fun createMinimalBST(arr: IntArray, start: Int, end: Int): TreeNode? {
            if (end < start) {
                return null
            }

            val mid = (start + end) / 2
            val n = TreeNode(arr[mid])
            n.setLeftChild(createMinimalBST(arr, start, mid - 1))
            n.setRightChild(createMinimalBST(arr, mid + 1, end))
            return n
        }
    }

    private var size: Int = 0

    val isBST: Boolean
        get() = kotlin.run {
            left?.let {
                if (data < it.data || !it.isBST) {
                    return false
                }
            }
            right?.let {
                if (data >= it.data || !it.isBST) {
                    return false
                }
            }
            return true
        }

    val height: Int
        get() = kotlin.run {
            val leftHeight = left?.height ?: 0
            val rightHeight = right?.height ?: 0
            return 1 + Math.max(leftHeight, rightHeight)
        }

    fun insertInOrder(d: Int) {
        if (d <= data) {
            left?.insertInOrder(d) ?: setLeftChild(TreeNode(d))
        } else {
            right?.insertInOrder(d) ?: setRightChild(TreeNode(d))
        }
        ++size
    }

    fun find(d: Int): TreeNode? = when {
        d == data -> this
        d <= data -> left?.find(d)
        d > data -> right?.find(d)
        else -> null
    }

    private fun setLeftChild(left: TreeNode?) {
        this.left = left
        left?.let { it.parent = this }
    }

    private fun setRightChild(right: TreeNode?) {
        this.right = right
        right?.let { it.parent = this }
    }

    fun print() {
        TODO("Implement BTreePrinter")
    }

}