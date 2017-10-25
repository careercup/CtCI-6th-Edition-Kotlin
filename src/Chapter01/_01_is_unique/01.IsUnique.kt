package Chapter01._01_is_unique


fun main(args: Array<String>) {
    println(IsUnique().isUniqueNormal(""))
}

class IsUnique {

    // O(n) solution
    fun isUniqueBest(s: String): Boolean {
        return s.length == s.toSet().size
    }

    // O(n) solution
    fun isUniqueBetter(s: String): Boolean {
        val charSet: MutableSet<Char> = mutableSetOf()
        for (c in s) {
            if (c in charSet)
                return false
            else
                charSet.add(c)
        }
        return true
    }

    // O(nlog(n)) solution (space complexity = O(n))
    fun isUniqueNormal(s: String): Boolean {
        val charList: List<Char> = s.toList().sorted()

        for ((index, value) in charList.withIndex()) {
            if (index == charList.size - 1)
                return true
            else if (value == charList[index + 1])
                return false
        }
        return true
    }

}