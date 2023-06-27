package y2023.jun

// https://leetcode.com/problems/equal-row-and-column-pairs/
class Solution0613 {
    fun equalPairs(grid: Array<IntArray>): Int {
        val n = grid.size
        val map = mutableMapOf<Int, Int>()

        // 가로 등록
        for (i in 0 until n) {
            val sb = StringBuilder()
            for (j in 0 until n) {
                sb.append(grid[i][j]).append(",")
            }
            // grid[i].joinToString(",")
            val key = sb.toString().hashCode()
            map[key] = (map[key] ?: 0) + 1
            map[key] = if(map[key] != null) map[key]!! + 1 else 0
            //map[key] = map.getOrDefault(key, 0) + 1
        }

        var ans = 0
        // 세로 만들면서 체크
        for (j in 0 until n) {
            val sb = StringBuilder()
            for (i in 0 until n) {
                sb.append(grid[i][j]).append(",")
            }
            ans += map[sb.toString().hashCode()] ?: 0
        }
        // 가로 : 2422, 2422
        // 세로 : 2422, 2422
        //       2개  -> 4개

        // 3 1 2 2 (3122 : 1, 1445 : 1, 2422 : 2)
        // 1 4 4 5
        // 2 4 2 2
        // 2 4 2 2

        return ans
    }
}

fun main() {
    val s = Solution0613()

    println(s.equalPairs(arrayOf(intArrayOf(3, 2, 1), intArrayOf(1, 7, 6), intArrayOf(2, 7, 7))))
}