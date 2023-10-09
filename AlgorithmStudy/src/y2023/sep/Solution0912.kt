package y2023.sep

// https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/?envType=daily-question&envId=2023-09-12
class Solution0912 {
    fun minDeletions(s: String): Int {

        var deleteCnt = 0
        val map = IntArray(26)
        s.map { map[it - 'a']++ }
        map.sort()
        val set = mutableSetOf<Int>()
        for (i in map.size - 1 downTo 0) {
            var fre = map[i]
            if (fre == 0) {
                break;
            }
            while (set.contains(fre)) {
                deleteCnt++
                fre--
            }
            if (fre != 0) {
                set.add(fre)
            }
        }

        return deleteCnt
    }
}