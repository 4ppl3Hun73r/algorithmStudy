package y2023.jul

import java.util.*

// https://leetcode.com/problems/knight-probability-in-chessboard/
class Solution0722 {
    fun knightProbability(n: Int, k: Int, row: Int, column: Int): Double {

        val knightMoves = arrayOf(
                intArrayOf(-2, 1), intArrayOf(-2, -1),
                intArrayOf(-1, 2), intArrayOf(-1, -2),
                intArrayOf(2, 1), intArrayOf(2, -1),
                intArrayOf(1, 2), intArrayOf(1, -2)
        )

        val dp = Array(k + 1) { Array(n) { DoubleArray(n) } }
        dp[0][row][column] = 1.0

        for (moves in 1..k) {
            for (i in 0 until n) {
                for (j in 0 until n) {
                    for (knightMove in knightMoves) {
                        val prevI = i - knightMove[0]
                        val prevJ = j - knightMove[1]
                        if (prevI in 0 until n && prevJ in 0 until n) {
                            dp[moves][i][j] += dp[moves - 1][prevI][prevJ] / 8.0
                        }
                    }
                }
            }
        }

        var totalProbability = 0.0
        for (i in 0 until n) {
            for (j in 0 until n) {
                totalProbability += dp[k][i][j]
            }
        }
        return totalProbability
    }

    fun knightProbabilityTLE(n: Int, k: Int, row: Int, column: Int): Double {

        val knightMove = arrayOf(
                intArrayOf(-2, 1), intArrayOf(-2, -1),
                intArrayOf(-1, 2), intArrayOf(-1, -2),
                intArrayOf(2, 1), intArrayOf(2, -1),
                intArrayOf(1, 2), intArrayOf(1, -2)
        )

        val queue: Queue<IntArray> = LinkedList()
        queue.add(intArrayOf(row, column))
        var k = k
        var result: Double = 1.0
        while (k != 0) {
            k--
            val size = queue.size
            var possibleMove = 0.0
            for (q in 0 until size) {
                val node = queue.poll()
                val i = node[0]
                val j = node[1]
                knightMove.forEach {
                    val newI = i + it[0]
                    val newJ = j + it[1]
                    if (newI in 0 until n && newJ in 0 until n) {
                        possibleMove++
                        queue.add(intArrayOf(newI, newJ))
                    }
                }
            }
            result = if (size != 0) {
                result * (possibleMove / (size * 8))
            } else {
                0.0
            }
        }


        return result
    }

}

fun main() {
    val s = Solution0722()

    println(s.knightProbability(3, 2, 0, 0))

}
/*
 [K][ ][ ]
 [ ][ ][ ]
 [ ][ ][ ]

2/8 * (4/16)
1/4 * (1/2) -> 1/8

0.25 * 0.25

 */