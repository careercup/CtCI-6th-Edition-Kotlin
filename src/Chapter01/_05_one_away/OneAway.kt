package Chapter01._05_one_away

import java.lang.Math.abs

fun main(args: Array<String>) {
    //println(OneAway().oneAway("pedram", "pedra"))
}

class OneAway {

    fun oneAway(str1: String, str2: String): Boolean {
        if (abs(str1.length - str2.length) > 1)
            return false

        val shorterStr: String
        val longerStr: String

        if (str1.length < str2.length){
            shorterStr = str1
            longerStr = str2
        } else {
            shorterStr = str2
            longerStr = str1
        }

        var foundDifference = false
        var idx1 = 0
        var idx2 = 0

        while (idx1 < shorterStr.length && idx2 < longerStr.length) {
            if (shorterStr[idx1] != longerStr[idx2]) {
                if (foundDifference) return false
                foundDifference = true

                if (shorterStr.length == longerStr.length)
                    idx1++
            } else {
                idx1++
            }
            idx2++
        }
        return true
    }

}