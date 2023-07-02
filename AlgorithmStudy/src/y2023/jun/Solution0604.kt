package y2023.jun

// https://leetcode.com/problems/number-of-provinces/
class Solution0604 {

    private lateinit var parent: IntArray
    fun find(x : Int) : Int {
        if (parent[x] == x) {
            return x
        } else {
            parent[x] = find(parent[x])
            return parent[x]
        }
    }

    fun union(x: Int, y: Int) {
        val _x = find(x)
        val _y= find(y)

        parent[_y] = _x
    }


    fun findCircleNum(isConnected: Array<IntArray>): Int {
        val n = isConnected.size

        parent = IntArray(n) {
            it
        }

        isConnected.forEachIndexed { x, conn ->
            conn.forEachIndexed { y, isConn ->
                if (x != y) {
                    if (isConn == 1) {
                        union(x, y)
                    }
                }
            }
        }

        val group = mutableSetOf<Int>()
        for ( x in 0 until n) {
            group.add(find(x))
        }

        return group.size
    }
}