package y2023.jun

// https://leetcode.com/problems/minimum-cost-to-make-array-equal/
class Solution0621 {
    fun minCost(nums: IntArray, cost: IntArray): Long {
        /*
        nums 의 값을 모두 동일하게 맞춰야 한다.
        1씩 변경가능하며 변경시마다 cost 값이 사용된다.
        최소로 사용하는 cost 는?

         */

        fun getCost(base: Int): Long {
            var costs: Long = 0
            nums.forEachIndexed { index, num ->
                costs += (Math.abs(base - num.toLong()) * cost[index].toLong())
            }
            return costs
        }

        var left: Int = Int.MAX_VALUE
        var right: Int = 0

        nums.forEach {
            left = Math.min(left, it)
            right = Math.max(right, it)
        }

        var minCost: Long = getCost(nums[0])
        while (left < right) {
            var mid = left + (right - left) / 2

            val cost1 = getCost(mid)
            val cost2 = getCost(mid + 1)

            minCost = Math.min(cost1, cost2)

            if (cost1 > cost2) {
                left = mid + 1
            } else {
                right = mid
            }
        }

        return minCost
    }
}