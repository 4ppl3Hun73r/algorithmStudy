package y2023.aug

// https://leetcode.com/problems/frog-jump/
class Solution0827 {
    fun canCross(stones: IntArray): Boolean {
        /*
        개구리가 강을 건너야 한다.
        k = 1 부터
        다음 거리는 k - 1, k, k + 1 이어야 한다.
         */

        val positions = mutableSetOf<Int>()
        for (stone in stones) {
            positions.add(stone)
        }
        val target = stones.last()



        return dfs(stones, positions, mutableSetOf<Int>(), 0, 0, target, mutableMapOf<String, Boolean>())
    }

    private fun dfs(
        stones: IntArray,
        positions: MutableSet<Int>,
        pathSet: MutableSet<Int>,
        position: Int,
        k: Int,
        target: Int,
        memo: MutableMap<String, Boolean>
    ): Boolean {
        val key = "$position,$k"
        if (memo.containsKey(key)) {
            return memo[key]!!
        }

        if (!positions.contains(position) || pathSet.contains(position)) {
            return false
        }

        pathSet.add(position)

        if (position == target) {
            return true
        }

        for (i in -1..1) {
            val nextPosition = position + k + i
            if (dfs(stones, positions, pathSet, nextPosition, k + i, target, memo)) {
                memo["$nextPosition,${k + i}"] = true
                return true
            } else {
                memo["$nextPosition,${k + i}"] = false
            }

        }
        pathSet.remove(position)

        return false
    }


}