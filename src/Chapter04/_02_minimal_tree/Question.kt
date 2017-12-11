package Chapter04._02_minimal_tree

import CtCILibrary.TreeNode


object Question {
    @JvmStatic
    fun main(args: Array<String>) {
        val array = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

        val root = TreeNode.createMinimalBST(array)
        println("Root? " + root?.data)
        println("Created BST? " + root?.isBST)
        println("Height: " + root?.height)
    }
}