package Chapter04._03_list_of_depths

import CtCILibrary.*
import java.util.*
import kotlin.collections.ArrayList

object SolutionDFS {
    @JvmStatic
    fun main(args: Array<String>) {
        val array = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val root = Utils.createTreeFromArray(array)
        val result = createLevelLinkedList(root)
        printResult(result)
    }

    private fun createLevelLinkedList(root: TreeNode?): List<LinkedList<TreeNode>> {
        return createLevelLinkedList(root, ArrayList(), 0)
    }

    private fun createLevelLinkedList(root: TreeNode?, lists: ArrayList<LinkedList<TreeNode>>, level: Int): List<LinkedList<TreeNode>> {
        root?.let {
            val list = when (lists.size == level) {
                true -> {
                    /* Levels are always traversed in order. So, if this is the first time we've visited level i,
			         * we must have seen levels 0 through i - 1. We can therefore safely add the level at the end. */
                    val tmp = LinkedList<TreeNode>()
                    lists.add(tmp)
                    tmp
                }
                false -> lists[level]
            }
            list.add(root)
            createLevelLinkedList(root.left, lists, level + 1)
            createLevelLinkedList(root.right, lists, level+1)
        }
        return lists
    }
}