package Chapter01._02_check_perm

fun main (args: Array<String>) {
    //println(CheckPermutation().checkPermBetter("pmerad", "pedram"))
}

class CheckPermutation {

    // O(nlog(n)) solution
    fun checkPermNormal(s1: String, s2: String): Boolean {
        if (s1.length != s2.length)
            return false

        return s1.toList().sorted() == s2.toList().sorted()
    }

    // O(n) solution
    fun checkPermBetter(s1: String, s2: String): Boolean {
        if (s1.length != s2.length)
            return false

        val s1Map = strToCountHashMap(s1)
        val s2Map = strToCountHashMap(s2)

        return s1Map == s2Map
    }

    private fun strToCountHashMap(s: String): HashMap<Char, Int> {

        val map: HashMap<Char, Int> = HashMap()

        for (char in s) {
            map[char] = (map[char] ?: 0) + 1
        }

        return map
    }

}