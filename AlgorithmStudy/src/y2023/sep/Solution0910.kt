package y2023.sep

// https://leetcode.com/problems/count-all-valid-pickup-and-delivery-options/?envType=daily-question&envId=2023-09-10
class Solution0910 {
    val mod = 1000000007L
    lateinit var cache: Array<LongArray>

    fun countOrders(n: Int): Int {
        cache = Array(n + 1) {
            LongArray(n + 1)
        }

        return allCombination(n, n).toInt()
    }

    private fun allCombination(np: Int, nd: Int): Long {
        if (np == 0 && nd == 0) {
            return 1
        }

        if (np < 0 || nd < 0 || nd < np) {
            return 0
        }

        if (cache[np][nd] != 0L) {
            return cache[np][nd]
        }
        var ans = 0L
        ans += np * allCombination(np - 1, nd)
        ans %= mod

        ans += (nd - np) * allCombination(np, nd - 1)
        ans %= mod

        cache[np][nd] = ans
        return ans
    }
}