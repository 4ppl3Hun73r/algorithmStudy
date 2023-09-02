package y2023.jul

// https://leetcode.com/problems/put-marbles-in-bags/
class Solution0708 {
    // 실패 ㅠ
    // 어렵다...
    fun putMarbles(weights: IntArray, k: Int): Long {
        /*
        i ~ j 까지는 모두 한 가방에 들어가야함, 그런데 무게는 i + j 임

        [1, 3, 5, 1], K = 2
        [1] (0, 0) => 2
        [3, 5, 1] (1 ~ 3) => 4
        2 + 4 => 6

        [1, 3](0, 1) => 4
        [5, 1](2, 3) => 6
        4 + 6 => 10

        10 - 6 = 4 <= result

        [1, 3] k = 2
        [1][3] => min == max = 0 <= result

         */
        val n = weights.size
        val pairWeights = Array(n - 1) { 0 }
        for ( i in 0 until n - 1) {
            pairWeights[i] = weights[i] + weights[i + 1]
        }

        pairWeights.sort()

        var answer: Long = 0
        for (i in 0 until k - 1) {
            answer += pairWeights[n - 2 - i] - pairWeights[i]
        }


        return answer
    }
}