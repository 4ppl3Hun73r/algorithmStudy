package y2023.jul


// https://leetcode.com/problems/minimum-size-subarray-sum/
class Solution0706 {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        //1,2,3,4,5      4,
        //1,2,3,4,5

        // O(n)
        var start = 0
        var target = target
        var result = Int.MAX_VALUE
        for ( end in nums.indices) {
            target -= nums[end]
            while(target <=0) {
                result = result.coerceAtMost(end - start + 1)
                target += nums[start++]
            }
        }
        return if(result == Int.MAX_VALUE) 0 else result

        // O (n log n)
        /*val prefixSum = Array(nums.size + 1) { 0 }
        prefixSum[0] = nums[0]
        nums.forEachIndexed { index, num ->
            prefixSum[index + 1] = prefixSum[index] + num
        }
        // println(prefixSum.joinToString(","))

        for ( len in 1.. nums.size) {
            for ( j in len..nums.size) {
                val sum = prefixSum[j] - prefixSum[j - len]
                if (sum >= target) {
                    return len
                }
            }
        }

        return 0*/
    }
}

fun main() {
    val s = Solution0706()
    println(s.minSubArrayLen(7, intArrayOf(2,3,1,2,4,3)))
}
