package y2023.jun

// https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/
class Solution0606 {

    fun canMakeArithmeticProgression(arr: IntArray): Boolean {
        arr.sort()
        val diff = arr[1] - arr[0]
        for (i in 2 until arr.size) {
            if (arr[i] - arr[i - 1] != diff) {
                return false
            }
        }

        return true
    }
}