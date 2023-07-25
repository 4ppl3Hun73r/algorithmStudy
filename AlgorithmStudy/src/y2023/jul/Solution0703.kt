package y2023.jul

// https://leetcode.com/problems/buddy-strings/
class Solution0703 {
    fun buddyStrings(s: String, goal: String): Boolean {
        //해시 갯수 다르면 false
        // 2개가 다를 경우
        // abcd, cbad
        // (a,c) , (c,a)
        // abcd, ebfd
        // aa, aa -> true
        // abac, abad
        if (s.length != goal.length) {
            return false
        }

        val len = s.length
        val diffIdxList = mutableListOf<Int>()
        val map = Array(26) { 0 }
        for (i in 0 until len) {
            if(s[i] != goal[i]) {
                diffIdxList.add(i)
            }
            map[s[i] - 'a']++
        }

        if (diffIdxList.size == 2) {
            return s[diffIdxList[0]] == goal[diffIdxList[1]] && s[diffIdxList[1]] == goal[diffIdxList[0]]
        }

        if (diffIdxList.size == 0) {
            for (count in map) {
                if (count >= 2) {
                    return true
                }
            }
        }

        return false
    }
}