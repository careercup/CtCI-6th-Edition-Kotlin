package CtCILibrary

import java.util.*

object Utils {
    fun createTreeFromArray(array: IntArray): TreeNode? {
        if (array.isEmpty()) {
            return null
        }

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

    fun printNode(root: TreeNode) {
        val maxLevel = maxLevel(root)
        printNode(listOf(root), 1, maxLevel)
    }

    private fun printNode(nodes: List<TreeNode?>, level: Int, maxLevel: Int) {
        if (nodes.filterNotNull().isEmpty()) {
            return
        }

        val floor = maxLevel - level
        val endgeLines = Math.pow(2.0, Math.max(floor - 1, 0).toDouble()).toInt()
        val firstSpaces = Math.pow(2.0, floor.toDouble()).toInt() - 1
        val betweenSpaces = Math.pow(2.0, (floor + 1).toDouble()).toInt() - 1

        printWhitespaces(firstSpaces)

        val newNodes = ArrayList<TreeNode?>()
        for (node in nodes) {
            node?.let { print(it.data) }
            newNodes.add(node?.left)
            newNodes.add(node?.right)
            node ?: print(" ")
            printWhitespaces(betweenSpaces)
        }
        println("")

        for (i in 1..endgeLines) {
            for (j in nodes.indices) {
                printWhitespaces(firstSpaces - i)
                if (nodes[j] == null) {
                    printWhitespaces(endgeLines + endgeLines + i + 1)
                    continue
                }

                if (nodes[j]?.left != null) {
                    print("/")
                } else {
                    printWhitespaces(1)
                }

                printWhitespaces(i + i - 1)

                if (nodes[j]?.right != null) {
                    print("\\")
                } else {
                    printWhitespaces(1)
                }
                printWhitespaces(endgeLines + endgeLines - i)
            }

            println("")
        }

        printNode(newNodes, level + 1, maxLevel)
    }

    private fun printWhitespaces(count: Int) {
        for (i in 0 until count) {
            print(" ")
        }
    }

    fun maxLevel(node: TreeNode?): Int {
        return node?.let {
            Math.max(maxLevel(node.left), maxLevel(node.right)) + 1
        } ?: 0
    }
}