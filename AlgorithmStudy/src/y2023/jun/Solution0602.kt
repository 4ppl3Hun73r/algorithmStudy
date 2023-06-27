package y2023.jun

import model.GridCodec
import java.util.*
import kotlin.math.max
import kotlin.math.pow
import kotlin.math.sqrt

// https://leetcode.com/problems/detonate-the-maximum-bombs/
class Solution0602 {
    fun maximumDetonation(bombs: Array<IntArray>): Int {
        val bombCnt = bombs.size
        // bombs 0 ~ size
        // n^2 = 10000, 100

        val bombMap = mutableMapOf<Int, MutableList<Int>>()
        bombs.forEachIndexed { index, it ->
            // 폭발 범위 안에 다른 폭탄이 있어야 하자나요
            bombMap[index] = mutableListOf()
            bombs.forEachIndexed { index2, it2 ->
                if (index != index2) {
                    if (contains(it, it2)) {
                        // 폭발 범위에 포함
                        bombMap[index]?.add(index2)
                    }
                }
            }
        }
        
        val visited = BooleanArray(bombCnt) {
            false
        }
        var result = 0
        bombs.forEachIndexed { index, _ ->
            result = max(result, dfs(index, bombMap, visited))
            Arrays.fill(visited, false)
        }
        return result
    }

    private fun dfs(bomb:Int, bombMap: Map<Int, List<Int>>, visited: BooleanArray): Int {
        if (visited[bomb]) {
            return 0
        }

        visited[bomb] = true
        var ans = 1
        bombMap[bomb]?.forEach {
            ans += dfs(it, bombMap, visited)
        }
        return ans
    }

    //bomb 폭발범위에 bomb2 가있는지확인
   private fun contains(bomb: IntArray, bomb2: IntArray) : Boolean {
        val (x,y,r) = bomb
        val (x2,y2) = bomb2

        //root ((y2-y1)^2 + (x2-x1)^2)
        val dist = sqrt(((y2 - y).toDouble()).pow(2.0) + ((x2 - x).toDouble()).pow(2.0))

        return dist <= r.toDouble()
    }
}

fun main() {

    val s = Solution0602()
    val g = GridCodec()
    println(s.maximumDetonation(g.getIntGrid("[[1,2,3],[2,3,1],[3,4,2],[4,5,3],[5,6,4]]")))
}