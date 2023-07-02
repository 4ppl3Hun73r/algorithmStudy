package y2023.jun

// https://leetcode.com/problems/maximum-value-at-a-given-index-in-a-bounded-array/
class Solution0610 {
    fun maxValue(n: Int, index: Int, maxSum: Int): Int {
        /*
            길이 n 의 배열을 만들어야 한다.
            nums[i] 의 값은 0 <= i < n 이되며
            abs(nums[i] - nums[i + 1]) <= 1 이어야 한다. 0 <= i < n - 1 에서
            모든 배열의 합은 maxSum을 넘지 않아야 하며

            nums[index] 는 최대어야 한다.
            nums[index]의 최대값을 반환

            n=4, index: 2, 6
            [1, 2, 2, 1]
            [0, 2, 3, 2] -> 안됨

            0이 되면 멈추고 무조건 1씩 빼고?
         */

        var left = 1
        var right = maxSum
        val maxSumAsLong = maxSum.toLong()
        fun sumAll(index: Int, value: Int, n: Int) : Long {
            var count: Long = 0
            count += if (value > index) {
                (value + value - index).toLong() * (index + 1).toLong() / 2L
            } else {
                (value + 1).toLong() * value / 2 + index - value + 1
            }

            count += if (value >= n - index) {
                (value + value - n + 1 + index).toLong() * (n - index) / 2
            } else {
                (value + 1).toLong() * value / 2 + n - index - value
            }
            println("${count} , ${value} , ${count - value.toLong()}")
            return count - value.toLong()
        }

        while (left < right) {
            val mid = (left + right + 1) / 2

            if (sumAll(index, mid, n) <= maxSumAsLong) {
                left = mid
            } else {
                right = mid - 1
            }
            println("left ${left} : right ${right}")
        }

        return left

    }
}

fun main() {
    val s = Solution0610()
    println(s.maxValue(1000000000, 449499449, 1000000000))
}