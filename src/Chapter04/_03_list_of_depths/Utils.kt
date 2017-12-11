package Chapter04._03_list_of_depths

import CtCILibrary.TreeNode
import java.util.*


fun printResult(result: List<LinkedList<TreeNode>>) {
    result.forEachIndexed { depth: Int, list: LinkedList<TreeNode> ->
        print("Link list at depth $depth:")
        list.forEach { print(" ${it.data}") }
        println()
    }
}

fun <E> LinkedList<E>.addNotNull(element: E?) {
    element?.let { this.add(it) }
}
