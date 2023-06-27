package y2023.jun

// https://leetcode.com/problems/summary-ranges/
class Solution0612 {
    fun summaryRanges(nums: IntArray): List<String> {
        val result = mutableListOf<String>()

        var outerIndex = 0
        while (outerIndex < nums.size) {
            val start = nums[outerIndex]

            while (outerIndex < nums.size - 1 && nums[outerIndex] == nums[outerIndex + 1] - 1) {
                outerIndex++
            }

            result.add(
                if (start == nums[outerIndex]) {
                    start.toString()
                } else {
                    "${start}->${nums[outerIndex]}"
                }
            )
            outerIndex++
        }
        return result
    }

    fun summaryRanges2(nums: IntArray): List<String> {
        var index = 0

        val lambdaFn:Function<Int> = {
            1
        }

        generateSequence({
            index++
            index++
            index++
        }){
            if (it > 100) return@generateSequence null
            println(it)
            it+1
        }.toList()

        println(index)

        return generateSequence {
            if (index >= nums.size) return@generateSequence null

            var initial = nums[index++]
            var curr = initial + 1

            while (index < nums.size && nums[index] == curr) {
                curr++
                index++
            }

            curr--

            if (curr == initial) "$initial"
            else "$initial->$curr"
        }.toList()
    }
}

fun main() {
    val s = Solution0612()
    s.summaryRanges2(intArrayOf(1, 2))
}