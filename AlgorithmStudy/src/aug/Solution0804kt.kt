package aug

import kotlin.math.pow

class SubsetsII {
    class Solution {
        fun subsetsWithDup(nums: IntArray): List<List<Int>> {
            val subsets = mutableSetOf<String>()

            // 2^nums.size - 1
            val maxSeqPattern = 2f.pow(nums.size).toInt() - 1

            // 000 0
            // 001 1
            // 010 2
            // 011 3
            // 100 4
            // 101 5
            // 110 6
            // 111 7 -> 2^3 -1
            // 111000000 -> 2^10 -1 = 1023

            for (seqPattern in 1..maxSeqPattern) {
                val subset = mutableListOf<Int>()
                // [1, 2, 2]
                // 0, 1, 2
                for ((binaryPosition, num) in nums.withIndex()) {
                    // seqPatter >> position | 1 == 1
                    if (((seqPattern shr binaryPosition) and 1) == 1) {
                        subset.add(num)
                    }
                }
                val subsetStr = subset.sorted().joinToString(separator = ",")
                subsets.add(subsetStr)
            }

            val answer: MutableList<List<Int>> = mutableListOf(emptyList<Int>())

            return subsets.mapTo(answer) {
                it.split(",")
                        .map(String::toInt)
            }
        }
    }
}

fun main() {
    println(SubsetsII.Solution().subsetsWithDup(intArrayOf(1,2,2)))
    println(SubsetsII.Solution().subsetsWithDup(intArrayOf(4,1,4,4)))
}
