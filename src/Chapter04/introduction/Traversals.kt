package Chapter04.introduction

import CtCILibrary.TreeNode

object Traversals {
    fun visit(node: TreeNode?) {
        println(node?.data)
    }

    fun inOrderTraversal(node: TreeNode?) {
        node?.let {
            inOrderTraversal(it.left)
            visit(it)
            inOrderTraversal(it.right)
        }
    }

    fun preOrderTraversal(node: TreeNode?) {
        node?.let {
            visit(it)
            inOrderTraversal(it.left)
            inOrderTraversal(it.right)
        }
    }

    fun postOrderTraversal(node: TreeNode?) {
        node?.let {
            inOrderTraversal(it.left)
            inOrderTraversal(it.right)
            visit(it)
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val intArray = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val root = TreeNode.createMinimalBST(intArray)
        inOrderTraversal(root)
    }
}