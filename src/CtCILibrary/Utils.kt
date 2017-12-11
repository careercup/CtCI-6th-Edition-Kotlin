package CtCILibrary

import java.util.*

object Utils {
    fun createTreeFromArray(array: IntArray): TreeNode? {
        if (array.isEmpty()) { return null }

        val root = TreeNode(array[0])
        val queue = LinkedList<TreeNode>()
        queue.add(root)

        var done = false
        var i = 1
        while (!done) {
            val r = queue.first
            when {
                r.left == null -> {
                    r.left = TreeNode(array[i])
                    i++
                    queue.add(r.left!!)
                }
                r.right == null -> {
                    r.right = TreeNode(array[i])
                    i++
                    queue.add(r.right!!)
                }
                else -> queue.remove()
            }
            if (i == array.size) {
                done = true
            }
        }
        return root
    }

    fun createTreeFromArray(array: Array<Int>): TreeNode? {
        return createTreeFromArray(array.toIntArray())
    }
}