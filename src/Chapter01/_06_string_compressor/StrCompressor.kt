package Chapter01._06_string_compressor

fun main(args: Array<String>) {
    println(StringCompressor().compress("aaaabcddeffffghhh"))
}

class StringCompressor {
    fun compress(str: String): String {

        if (!str.matches(Regex("[a-zA-Z]+")))
            throw IllegalArgumentException()

        var idx = 0
        var count: Int
        var currentChar: Char
        val sb = StringBuilder()
        while (idx < str.length) {
            currentChar = str[idx]

            count = 1
            while (idx != str.length - 1 && str[idx + 1] == currentChar) {
                idx++
                count++
            }

            sb.append(currentChar, count)
            idx++
        }

        val result = sb.toString()

        return if (result.length > str.length) str else result
    }
}