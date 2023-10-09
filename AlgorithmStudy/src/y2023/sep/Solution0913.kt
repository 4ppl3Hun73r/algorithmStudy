package y2023.sep


// https://leetcode.com/problems/candy/?envType=daily-question&envId=2023-09-13
class Solution0913 {
    fun candy(ratings: IntArray): Int {
        val candyLeft = IntArray(ratings.size) { 1 }
        val candyRight = IntArray(ratings.size) { 1 }

        for (i in 1 until candyLeft.size) {
            if (ratings[i] > ratings[i - 1]) {
                candyLeft[i] = candyLeft[i - 1] + 1
            }
        }

        for (i in candyRight.size - 2 downTo 0) {
            if (ratings[i] > ratings[i + 1]) {
                candyRight[i] = candyRight[i + 1] + 1
            }
        }

        var sum = 0
        for (i in ratings.indices) {
            sum += Math.max(candyLeft[i], candyRight[i])
        }
        return sum
    }
}