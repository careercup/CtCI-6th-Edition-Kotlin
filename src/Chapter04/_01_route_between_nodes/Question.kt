package Chapter04._01_route_between_nodes

import java.util.*

object Question {
    @JvmStatic
    fun main(args: Array<String>) {
        val graph = createGraph()
        val nodes = graph.nodes
        val start = nodes[3]
        val end = nodes[5]
        println(isConnected(graph, start, end))
    }

    private fun <T> isConnected(graph: Graph<T>, start: Node<T>, end: Node<T>): Boolean {
        val queue = LinkedList<Node<T>>()
        graph.nodes.forEach { it.state = State.Unvisited }

        start.state = State.Visiting
        queue.add(start)
        while (!queue.isEmpty()) {
            queue.removeFirst()?.let {
                it.adjacent
                        .filter { it.state == State.Unvisited }
                        .forEach {
                            if (it == end) {
                                return true
                            } else {
                                it.state = State.Visiting
                                queue.add(it)
                            }
                        }
            }
        }

        return false
    }
    
    private fun createGraph(): Graph<String> {
        val n0 = Node("a", 3)
        val n1 = Node("b", 0)
        val n2 = Node("c", 0)
        val n3 = Node("d", 1)
        val n4 = Node("e", 1)
        val n5 = Node("f", 0)

        val graph = Graph(arrayOf(n0, n1, n2, n3, n4, n5))
        n0.adjacent = arrayOf(n1, n2, n3)
        n3.adjacent = arrayOf(n4)
        n4.adjacent = arrayOf(n5)
        return graph
    }
}