package y2023.aug

// https://leetcode.com/problems/excel-sheet-column-title/
class Solution0822 {
    fun convertToTitle(columnNumber: Int): String {
        val sb = StringBuilder()

        var columnNumber = columnNumber
        while (columnNumber != 0) {
            columnNumber--
            val m = columnNumber % 26
            sb.append('A' + m)
            columnNumber = columnNumber / 26
        }

        return sb.reverse().toString()
    }
}