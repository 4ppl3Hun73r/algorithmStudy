package y2023.jun

import java.util.*


// https://leetcode.com/problems/shortest-path-to-get-all-keys/
class Solution0629 {
    fun shortestPathAllKeys(grid: Array<String>): Int {
        /*
        @스타트 포인트
        # 벽
        [a-z] key / [A-Z] lock

        모든 key를 찾는 가장 짧은 경로
         */
        val dirs = arrayOf(intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(-1, 0))
        val queue: Queue<IntArray> = LinkedList()

        val r = grid.size
        val c = grid[0].length
        val seen: MutableMap<Int, MutableSet<Pair<Int, Int>>> = mutableMapOf()
        val keySet = mutableSetOf<Char>()
        val lockSet = mutableSetOf<Char>()
        var allKey = 0
        var startR = -1
        var startC = -1

        for(i in 0 until r)  {
            for(j in 0 until c)  {
                val c = grid[i][j]
                if (c.isLetter() && c.isLowerCase()) {
                    allKey += (1 shl (c - 'a'))
                    keySet.add(c)
                } else if (c.isLetter() && c.isUpperCase()) {
                    lockSet.add(c)
                }
                if (c == '@') {
                    startR = i
                    startC = j
                }
            }
        }

        queue.offer(intArrayOf(startR, startC, 0, 0))
        seen[0] = mutableSetOf()
        seen[0]?.add(startR to startC)
        while (queue.isNotEmpty()) {
            val curr = queue.poll()
            val curR = curr[0]
            val curC = curr[1]
            val keys = curr[2]
            val dist = curr[3]

            for (dir in dirs) {
                val newR = curR + dir[0]
                val newC = curC + dir[1]

                if (newR >=0 && newC >= 0 && newR < r && newC < c && grid[newR][newC] != '#') {
                    val c = grid[newR][newC]

                    if (keySet.contains(c)) {
                        if ((1 shl c - 'a') and keys != 0) {
                            continue
                        }

                        val newKeys = keys or (1 shl c - 'a')

                        if (newKeys == allKey) {
                            return dist + 1
                        }
                        seen.putIfAbsent(newKeys, mutableSetOf())
                        seen[newKeys]?.add(newR to newC)
                        queue.offer(intArrayOf(newR, newC, newKeys, dist + 1))
                    }

                    if (lockSet.contains(c) && (keys and (1 shl c - 'A') == 0)) {
                        continue
                    } else if (!seen[keys]?.contains(newR to newC)!!) {
                        seen[keys]?.add(newR to newC)
                        queue.offer(intArrayOf(newR, newC, keys, dist + 1))
                    }

                }
            }
        }




        return -1
    }
}