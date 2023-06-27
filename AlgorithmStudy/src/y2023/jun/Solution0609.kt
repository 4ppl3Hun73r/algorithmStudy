package y2023.jun

// https://leetcode.com/problems/find-smallest-letter-greater-than-target/
class Solution0609 {

    fun nextGreatestLetter(letters: CharArray, target: Char): Char {
        letters.forEach {
            if (it > target) {
                return it
            }
        }

        return letters[0]
    }


}