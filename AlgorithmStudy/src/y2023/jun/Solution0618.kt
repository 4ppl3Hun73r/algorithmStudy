package y2023.jun

// https://leetcode.com/problems/number-of-increasing-paths-in-a-grid/
class Solution0618 {
    val mod = 1000000007
    var rSize = 0
    var cSize = 0
    val dirs = arrayOf(0 to 1, 0 to -1, 1 to 0, -1 to 0)

    fun countPaths(grid: Array<IntArray>): Int {

        rSize = grid.size
        cSize = grid[0].size

        var result = 0
        val memo = Array(rSize) {
            Array(cSize) {
                0
            }
        }
        for (r in 0 until rSize) {
            for (c in 0 until cSize) {
                result = (result + dfs(r, c, grid, memo)) % mod
            }
        }
        return result
    }

    private fun dfs(r: Int, c: Int, grid: Array<IntArray>, memo: Array<Array<Int>>): Int {
        if (r == rSize || c == cSize) {
            return 0
        }

        if (memo[r][c] != 0) {
            return memo[r][c]
        }


        var result = 1


        val curr = grid[r][c]
        for (dir in dirs) {
            val nr = r + dir.first
            val nc = c + dir.second

            if (nr < 0 || nc < 0 || nr == rSize || nc == cSize || curr >= grid[nr][nc]) {
                continue
            }

            result = (result + dfs(nr, nc, grid, memo)) % mod
        }
        memo[r][c] = result

        return result
    }

}

fun main() {
    val s = Solution0618()

    println(s.countPaths(arrayOf(
        intArrayOf(1, 1), intArrayOf(3, 4))
    ))

    println(s.countPaths(arrayOf(
        intArrayOf(1), intArrayOf(2)
    )))

}

/*

[[73884,15322,92124,16515,54702,88526,61879,14125,21161,42701,35686,75932,8696],
 [59537,80396,65708,32310,46753,39759,4746,71413,84723,13233,23640,62230,11825],
 [6414,96122,64501,32523,55259,2935,44772,48912,26516,56256,69201,21079,52979],
 [50951,1748,42645,73435,81511,21445,26066,27605,40388,43702,47233,15333,86291],
 [87914,90237,95947,97341,93670,79822,32591,44096,55112,89104,36097,82759,15504],
 [3604,74013,74414,68295,58798,7050,71657,33463,38040,46180,61730,82754,57179],
 [86867,1972,13704,11581,99042,24825,77747,38671,40628,38626,54719,7366,36309],
 [69272,98273,16474,15204,40263,99956,36072,68173,77076,18094,97439,61968,7435],
 [95263,39616,37983,61376,256,7169,45149,94957,66151,13256,37776,25331,29659],
 [90001,12571,31093,46714,52347,44882,76055,53662,69928,37486,44020,2211,67466]]
 */