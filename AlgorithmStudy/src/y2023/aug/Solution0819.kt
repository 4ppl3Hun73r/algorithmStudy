package y2023.aug

// https://leetcode.com/problems/find-critical-and-pseudo-critical-edges-in-minimum-spanning-tree/
class Solution0819 {
    fun findCriticalAndPseudoCriticalEdges(n: Int, edges: Array<IntArray>): List<List<Int>> {
        val m = edges.size
        val newEdges = Array(m) {
            IntArray(4)
        }

        for (i in 0 until m) {
            for (j in 0 until 3) {
                newEdges[i][j] = edges[i][j]
            }
            newEdges[i][3] = i
        }

        newEdges.sortBy { it[2] }

        val ufStd = Uf(n)
        var stdWeight = 0
        for (edge in newEdges) {
            if (ufStd.union(edge[0], edge[1])) {
                stdWeight += edge[2]
            }
        }

        val result = mutableListOf<MutableList<Int>>()
        result.add(mutableListOf())
        result.add(mutableListOf())

        for (i in 0 until m) {
            val ufIgnore = Uf(n)
            var ignoreWeight = 0
            for (j in 0 until m) {
                if (i != j && ufIgnore.union(newEdges[j][0], newEdges[j][1])) {
                    ignoreWeight += newEdges[j][2]
                }
            }

            if (ufIgnore.maxSize < n || ignoreWeight > stdWeight) {
                result[0].add(newEdges[i][3])
            } else {
                val ufForce = Uf(n)
                ufForce.union(newEdges[i][0], newEdges[i][1])
                var forceWeight = newEdges[i][2]
                for (j in 0 until m) {
                    if (i != j && ufForce.union(newEdges[j][0], newEdges[j][1])) {
                        forceWeight += newEdges[j][2]
                    }
                }
                if (forceWeight == stdWeight) {
                    result[1].add(newEdges[i][3])
                }
            }
        }

        return result
    }

    class Uf(val n: Int) {
        val parent = IntArray(n)
        val size = IntArray(n) { 1 }
        var maxSize = 1
        init {
            for (i in 0 until n) {
                parent[i] = i
            }
        }

        fun find(x: Int): Int {
            if (x != parent[x]) {
                parent[x] = find(parent[x])
            }
            return parent[x]
        }

        fun union(x: Int, y: Int): Boolean {
            var rootX = find(x)
            var rootY = find(y)
            if (rootX != rootY) {
                if (size[rootX] < size[rootY]) {
                    val temp = rootX
                    rootX = rootY
                    rootY = temp
                }
                parent[rootY] = rootX
                size[rootX] += size[rootY]
                maxSize = Math.max(maxSize, size[rootX])
                return true
            }
            return false
        }
    }
}