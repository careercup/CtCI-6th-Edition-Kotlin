package Chapter04._03_list_of_depths

import CtCILibrary.*
import java.util.*
import kotlin.collections.ArrayList

object QuestionBFS {
    @JvmStatic
    fun main(args: Array<String>) {
        val nodes = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val root = Utils.createTreeFromArray(nodes)
        val list = createLevelLinkedList(root)
        printResult(list)
    }

    private fun createLevelLinkedList(root: TreeNode?): List<LinkedList<TreeNode>> {
        val result = ArrayList<LinkedList<TreeNode>>()

        var current = LinkedList<TreeNode>()
        current.addNotNull(root)

        while (current.size > 0) {
            result.add(current) //add previous level
            val parents = current //go to next level

            current = LinkedList()
            parents.forEach { parent ->
                current.addNotNull(parent.left)
                current.addNotNull(parent.right)
            }
        }
        return result
    }
}