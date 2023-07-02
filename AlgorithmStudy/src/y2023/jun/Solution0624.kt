package y2023.jun

// https://leetcode.com/problems/tallest-billboard/
class Solution0624 {
    fun tallestBillboard(rods: IntArray): Int {
        /*
            배열을 2개의 그룹으로 나누느데, 양쪽이 크기가 같아야 하고 가장 커야 한다.
            배열안의 모든 값을 사용 할 필요는 없다.
         */

        var dp = mutableMapOf(0 to 0)

        for (rod in rods) {
            val newDp = dp.toMutableMap()

            for (entry in dp.entries) {
                val diff = entry.key
                val taller = entry.value
                val shorter = taller - diff

                val newTaller = newDp[diff + rod] ?: 0
                newDp[diff + rod] = Math.max(newTaller, taller + rod)

                val newDiff = Math.abs(shorter + rod - taller)
                val newTaller2 = Math.max(shorter + rod, taller)
                newDp[newDiff] = Math.max(newTaller2, newDp[newDiff] ?: 0)
            }
            dp = newDp
        }
        /*
        1,2,3,4,5,6

        dp = {0, 0}
         diff taller shorter newTaller   newDp    newDiff     newTaller2     newDp
           0,    0,     0       0        {1, 1}      1             1         {1,1}
        dp = {0, 0}, {1, 1}
           0,    0,     0       0        {2, 2}      2             2         {2,2}
           1,    1,     0       0        {3, 3}      2             3         {2,3}
        dp = {0, 0}, {1, 1}, {2, 3}, {3, 3}


         */

        return dp[0] ?: 0

    }
}