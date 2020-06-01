package Chapter01._02_check_perm

fun main (args: Array<String>) {
    //println(CheckPermutation().checkPermBetter("pmerad", "pedram"))
}

class CheckPermutation {

    // Solutions are case sensitive and white spaces are significant

    // O(nlog(n)) solution
    fun checkPermNormal(str1: String, str2: String): Boolean {
        if (str1.length != str2.length)
            return false

        return str1.toList().sorted() == str2.toList().sorted()
    }

    // O(n) solution
    fun checkPermBetter(str1: String, str2: String): Boolean {
        if (str1.length != str2.length)
            return false

        val str1Map = strToCountHashMap(str1)
        val str2Map = strToCountHashMap(str2)

        return str1Map == str2Map
    }

    private fun strToCountHashMap(str: String): HashMap<Char, Int> {

        val map: HashMap<Char, Int> = HashMap()

        str.forEach {
            map[it] = (map[it] ?: 0) + 1
        }

        return map
    }

}