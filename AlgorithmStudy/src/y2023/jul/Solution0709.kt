package y2023.jul

import java.util.*

// https://leetcode.com/problems/substring-with-largest-variance/
class Solution0709 {

    fun largestVariance(s: String): Int {

        val counter = Array(26) {0}
        s.forEach {
            counter[it - 'a'] ++
        }

        var globalMax = 0


        for (i in 0 until 26) {
            for (j in 0 until 26) {
                if (i == j || counter[i] == 0 || counter[j] == 0) {
                    continue
                }
                val major = 'a' + i
                val minor = 'a' + j
                var majorCnt = 0
                var minorCnt = 0
                var restMinor = counter[j]

                s.forEach {
                    if (it == major) {
                        majorCnt++
                    }
                    if (it == minor) {
                        minorCnt++
                        restMinor--
                    }

                    if (minorCnt > 0) {
                        globalMax = globalMax.coerceAtLeast(majorCnt - minorCnt)
                    }

                    if (majorCnt < minorCnt && restMinor > 0) {
                        majorCnt = 0
                        minorCnt = 0
                    }

                }

            }
        }

        return globalMax

    }

    fun largestVarianceJiho(s: String): Int {
        /*
        모든 서브시퀀스 중

        aa -> a2 -> 0
        ab -> a1, b1 -> a1 - b1 = 0
        aab -> a2, b1 -> a2 - b1 = 1
        aaaba -> a4, b1 -> a4 - b1 = 3

        abcde
        -> all 0
         */

        val len = s.length
        var ans = 0
        for ( i in 1..len) {
            val treeMap = TreeMap<Char, Int>()
            for (j in 0 until len - i + 1) {

            }
        }


        for ( i in 0 until len) {
            for (j in i + 1 until len + 1) {
                //ans = ans.coerceAtLeast(getDiff(s, i, j))
            }
        }

        return ans
    }

    fun getDiff(s: String, start: Int, end: Int) : Int {
        val subSeq = s.substring(start, end)

        val arr = Array(26) { 0 }
        var cnt = 0
        subSeq.forEach {
            if (arr[it - 'a'] == 0) {
                cnt++
            }
            arr[it - 'a']++
        }
        arr.sortDescending()
        println("$subSeq : ${arr[0] - arr[cnt - 1]}")
        if (cnt == 1) {
            return 0
        }

        return arr[0] - arr[cnt - 1]
    }
}

fun main() {
    val s = Solution0709()
    println(s.largestVariance("aababbb"))
    println(s.largestVariance("abcde"))

}