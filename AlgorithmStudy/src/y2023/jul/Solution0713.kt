package y2023.jul

// https://leetcode.com/problems/course-schedule/
class Solution0713 {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        /*
        2, [[1,0]]

        1을 수강하려면 0을 수강해야 한다.

        // circle 이 있으면 false
        // circle 이 없이 모두 visited 하면 true
                visited     if visited? false?
        // 0 -> [i]     -> j
         */
        // 0 ~ numCourses - 1

        val 필수수강목록 = Array(numCourses) {
            mutableSetOf<Int>()
        }
        val 수강가능목록 = Array(numCourses) {
            mutableSetOf<Int>()
        }

        prerequisites.forEach {
            필수수강목록[it[0]].add(it[1])
            수강가능목록[it[1]].add(it[0])
        }

        /*
          필수수강목록
          [0] -> []
          [1] -> [0]
          [2] -> [0,1]

          수강가능목록
          [0] -> [1,2]
          [1] -> [2]
          [2] -> []

         */

        val visited = Array(numCourses) {false}
        필수수강목록.forEachIndexed { index, ints ->
            if (ints.size == 0) {
                // 이걸 기준으로 탐색을 하는건데
                visited[index] = true
                dfs(수강가능목록, 필수수강목록, visited, index)
            }
        }

        return visited.none { !it }
    }

    private fun dfs(수강가능목록: Array<MutableSet<Int>>, 필수수강목록: Array<MutableSet<Int>>, visited: Array<Boolean>, 수강코스: Int) {

        수강가능목록[수강코스].forEach {
            필수수강목록[it].remove(수강코스)
            if(필수수강목록[it].size == 0) {
                if (!visited[it]) {
                    visited[it] = true
                    dfs(수강가능목록, 필수수강목록, visited, it)
                }
            }
        }
    }
}

fun main() {
    val s = Solution0713()
    
    //println(s.canFinish(2, Array(2) {
    //    intArrayOf(1, 0)
    //}))

    println(s.canFinish(2, Array(2) {
        intArrayOf(0, 1)
    }))
}