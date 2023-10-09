package y2023.sep


// https://leetcode.com/problems/pascals-triangle/?envType=daily-question&envId=2023-09-08
class Solution0908 {
    fun generate(numRows: Int): List<List<Int>> {
        val ans = mutableListOf<MutableList<Int>>()
        var row = mutableListOf<Int>()
        row.add(1)
        ans.add(row)
        for (i in 1 until numRows) {
            row = mutableListOf<Int>()
            val prev = ans[i - 1]
            for (j in 0..i) {
                var value = 1
                if (j != 0 && j != i) value = prev[j - 1] + prev[j]
                row.add(value)
            }
            ans.add(row)
        }

        return ans
    }
}