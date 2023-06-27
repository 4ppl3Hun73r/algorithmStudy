package y2023.jun

// https://leetcode.com/problems/k-radius-subarray-averages/
class Solution0620 {
    fun getAverages(nums: IntArray, k: Int): IntArray {
        val windowSize: Long = (k * 2).toLong()
        var sliding: Long = 0
        var sum: Long = 0

        val result = IntArray(nums.size) {
            -1
        }
        nums.forEachIndexed { index, num ->
            sum += num
            if (sliding == windowSize) {
                result[index - k] = (sum / (windowSize + 1)).toInt()
                sum -= nums[(index - windowSize).toInt()]
            } else {
                sliding++
            }
        }

        return result
    }
}

fun main() {
    val s = Solution0620()
    println(s.getAverages(intArrayOf(7,4,3,9,1,8,5,2,6), 3))
}