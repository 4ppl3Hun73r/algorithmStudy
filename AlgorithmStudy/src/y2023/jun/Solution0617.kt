package y2023.jun

class Solution0617 {
    fun makeArrayIncreasing(arr1: IntArray, arr2: IntArray): Int {

        arr2.sort()

        val ans = dfs(0, -1, arr1, arr2)

        return if (ans < 2001) ans else -1
    }

    private val memo = mutableMapOf<Pair<Int, Int>, Int>()

    private fun dfs(i: Int, prev: Int, arr1: IntArray, arr2: IntArray): Int {
        if (i == arr1.size) {
            return 0
        }

        val key = i to prev
        if (memo.containsKey(key)) {
            return memo[key]!!
        }

        var cost = 2001
        if (arr1[i] > prev) {
            cost = dfs(i + 1, arr1[i], arr1, arr2)
        }

        val idx = bisectRight(arr2, prev)

        if (idx < arr2.size) {
            cost = Math.min(cost, 1 + dfs(i + 1, arr2[idx], arr1, arr2))
        }

        memo[key] = cost
        return cost
    }

    private fun bisectRight(arr2: IntArray, prev: Int): Int {
        var left = 0
        var right = arr2.size

        while (left < right) {
            val mid = (left + right) / 2
            if (arr2[mid] <= prev) {
                left = mid + 1
            } else {
                right = mid
            }
        }
        return left
    }
}