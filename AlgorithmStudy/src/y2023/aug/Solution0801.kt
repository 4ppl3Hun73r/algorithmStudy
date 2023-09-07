package y2023.aug


// https://leetcode.com/problems/combinations/
class Solution0801 {
    var result: MutableList<List<Int>> = mutableListOf()

    fun combine(n: Int, k: Int): List<List<Int>> {
        for (i in 1..n) {
            val c: MutableList<Int> = ArrayList(k)
            c.add(i)
            combination(i + 1, n, k - 1, c)
        }
        return result
    }

    private fun combination(start: Int, n: Int, k: Int, c: MutableList<Int>) {
        if (k == 0) {
            result.add(ArrayList<Int>(c))
        }
        for (i in start..n) {
            c.add(i)
            combination(i + 1, n, k - 1, c)
            c.removeAt(c.size - 1)
        }
    }
}