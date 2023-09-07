package y2023.aug

// https://leetcode.com/problems/minimum-penalty-for-a-shop/
class Solution0829 {
    fun bestClosingTime(customers: String): Int {
        /*
        YYNY
        0 -> 1 1 0 1
        1 -> 0 1 0 1
        2 -> 0 0 0 1
        3 -> 0 0 1 1
        4 -> 0 0 1 0

        n 을 기준으로 앞에 있는 N의 수 뒤에 있는 Y 의 수를 미리 구해 놓고 검색

         */
        var currPenalty = customers.count { it == 'Y' }
        var minPenalty = currPenalty
        var closeHour = 0
        for (i in customers.indices) {
            val ch = customers[i]

            if (ch == 'Y') {
                currPenalty --
            } else {
                currPenalty ++
            }

            if (currPenalty < minPenalty) {
                closeHour = i + 1
                minPenalty = currPenalty
            }
        }

        return closeHour
    }
}