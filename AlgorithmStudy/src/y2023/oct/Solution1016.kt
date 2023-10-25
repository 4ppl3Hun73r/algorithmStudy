package y2023.oct

// https://leetcode.com/problems/pascals-triangle-ii/?envType=daily-question&envId=2023-10-16
class Solution1016 {
    fun getRow(rowIndex: Int): List<Int> {
        val row = mutableListOf<Int>()
        val r: Long = rowIndex.toLong() + 1

        var col : Long = 1
        for (i in 1 .. r) {
            row.add(col.toInt())
            col = col * (r - i) / i
        }

        return row
    }
}