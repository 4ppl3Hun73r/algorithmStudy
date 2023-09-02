package y2023.aug

// https://leetcode.com/problems/maximum-length-of-pair-chain/
class Solution0826 {
    fun findLongestChain(pairs: Array<IntArray>): Int {
        /*
        [a, b] [c, d] [e, f]
        a < b < c < d < e < f
        b < c ,  d < e
         */
        val comparator = Comparator<IntArray> { a, b ->
            a[1] - b[1]
        }
        pairs.sortWith(comparator)

        var right = -1001
        var ans = 0

        for (pair in pairs) {
            if (right < pair[0]) {
                ans++
                right = pair[1]
            }
        }

        return ans
    }
}

fun main() {
    val s = Solution0826()

    println(s.findLongestChain(arrayOf(intArrayOf(3, 4), intArrayOf(2, 3), intArrayOf(1, 2))))

}