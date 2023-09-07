package y2023.aug

import java.util.*

// https://leetcode.com/problems/sliding-window-maximum/
class Solution0816 {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val result = mutableListOf<Int>()
        val treeMap = TreeMap<Int, Int>()
        for (i in 0 until k) {
            if (treeMap[nums[i]] == null) {
                treeMap[nums[i]] = 0
            }
            treeMap[nums[i]] = treeMap[nums[i]]!! + 1
        }

        result.add(treeMap.lastKey())
        for (i in k until nums.size) {
            val removeElement = nums[i - k]
            val insertElement = nums[i]

            treeMap[removeElement] = treeMap[removeElement]!! - 1
            if (treeMap[removeElement] == 0) {
                treeMap.remove(removeElement)
            }
            if (treeMap[insertElement] == null) {
                treeMap[insertElement] = 0
            }
            treeMap[insertElement] = treeMap[insertElement]!! + 1
            result.add(treeMap.lastKey())
        }

        return result.toIntArray()
    }
}