package y2023.oct

// https://leetcode.com/problems/remove-colored-pieces-if-both-neighbors-are-the-same-color/description/?envType=daily-question&envId=2023-10-02
class Solution1002 {
    fun winnerOfGame(colors: String): Boolean {

        var alice = 0
        var bob = 0
        var count = 1

        for (i in 1 until colors.length) {
            if (colors[i] == colors[i - 1]) {
                count += 1
            } else {
                if (colors[i - 1] == 'A') {
                    alice += Math.max(0, count - 2)
                } else {
                    bob += Math.max(0, count - 2)
                }
                count = 1
            }
        }

        if (colors.last() == 'A') {
            alice += Math.max(0, count - 2)
        } else {
            bob += Math.max(0, count - 2)
        }

        return alice > bob

    }
}