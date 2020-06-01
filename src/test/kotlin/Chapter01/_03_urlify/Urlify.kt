package Chapter01._03_urlify

fun main(args: Array<String>) {
    println(Urlify().urlifyAlt("Pedram      ", 8))
}

class Urlify {

    // run time: O(n), space: O(1)
    fun urlify(str: CharArray, strSize: Int): String {

        if (str.size == strSize)
            return String(str)

        val requiredSize = strSize + (0 until strSize).count { str[it] == ' ' } * 2

        var targetIdx = requiredSize - 1
        for (idx in strSize - 1 downTo 0)
            if (str[idx] != ' ') {
                str[targetIdx--] = str[idx]
            }
            else {
                str[targetIdx] = '0'
                str[targetIdx - 1] = '2'
                str[targetIdx - 2] = '%'
                targetIdx -= 3
            }

        return String(str)
    }

    // run time: O(n), space: O(n)
    fun urlifyAlt(str: String, strSize: Int): String {

        val replacementStr = "%20"
        val sb = StringBuilder()

        for (idx in 0 until strSize) { if (str[idx] != ' ') sb.append(str[idx]) else sb.append(replacementStr) }

        return sb.toString()
    }
}