package y2023.jul


// https://leetcode.com/problems/smallest-sufficient-team/
class Solution0716 {
    fun Long.countOneBits(): Int = java.lang.Long.bitCount(this)

    fun smallestSufficientTeam(req_skills: Array<String>, people: List<List<String>>): IntArray {

        val n = people.size
        val skillSize = req_skills.size
        val skillIdMap = mutableMapOf<String, Int>()

        req_skills.forEachIndexed { index, s ->
            skillIdMap[s] = index
        }
        val skillMaskPerson = IntArray(n)
        people.forEachIndexed { index, list ->
            list.forEach {
                skillMaskPerson[index] = skillMaskPerson[index] or (1 shl skillIdMap[it]!!)

            }
        }

        val dp = LongArray(1 shl skillSize) { (1L shl n) - 1}
        dp[0] = 0

        for (mask in 1 until (1 shl skillSize)) {
            for (i in 0 until n) {
                val smallerSkillMask = mask and skillMaskPerson[i].inv()
                if (smallerSkillMask != mask) {
                    val peopleMask = dp[smallerSkillMask] or (1L shl i)
                    if (peopleMask.countOneBits() < dp[mask].countOneBits()) {
                        dp[mask] = peopleMask
                    }
                }

            }
        }

        var ansMask = dp[(1 shl skillSize) - 1]
        val ans = IntArray(ansMask.countOneBits())
        var pointer = 0
        for (i in 0 until n) {
            if (((ansMask shr i) and 1) == 1L) {
                ans[pointer++] = i
            }
        }

        return ans
    }
}
