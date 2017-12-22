package Chapter04._01_route_between_nodes

class Node<T>(
        val value: T,
        val adjacentLength: Int,
        var adjacent: Array<Node<T>> = emptyArray(),
        var state: State = State.Unvisited
) {
    private var adjacentCount: Int = 0

    fun addAjacent(x: Node<T>) {
        if (adjacentCount < adjacent.size) {
            this.adjacent[adjacentCount] = x
            ++adjacentCount
        } else {
            println("No more adjacent can be added")
        }
    }
}