package y2023.aug

// https://leetcode.com/problems/text-justification/
class Solution0824 {
    fun fullJustify(words: Array<String>, maxWidth: Int): List<String> {
        val ans = mutableListOf<String>()

        var i = 0
        while (i < words.size) {
            val currentLine = getWords(i, words, maxWidth)
            i += currentLine.size
            ans.add(createLine(currentLine, i, words, maxWidth))
        }

        return ans
    }

    private fun createLine(currentLine: MutableList<String>, i: Int, words: Array<String>, maxWidth: Int): String {
        var baseLength = -1
        for (word in currentLine) {
            baseLength += word.length + 1
        }

        val extraSpaces = maxWidth - baseLength

        if (currentLine.size == 1 || i == words.size) {
            return currentLine.joinToString(" ") + " ".repeat(extraSpaces)
        }

        val wordCount = currentLine.size - 1
        val spacesPerWord = extraSpaces / wordCount
        val needsExtraSpace = extraSpaces % wordCount

        for (j in 0 until needsExtraSpace) {
            currentLine[j] = currentLine[j] + " "
        }

        for (j in 0 until wordCount) {
            currentLine[j] = currentLine[j] + " ".repeat(spacesPerWord)
        }

        return currentLine.joinToString(" ")
    }

    private fun getWords(i: Int, words: Array<String>, maxWidth: Int): MutableList<String> {
        val currentLine = mutableListOf<String>()
        var currLength = 0

        var i = i
        while (i < words.size && currLength + words[i].length <= maxWidth) {
            currentLine.add(words[i])
            currLength += words[i].length + 1
            i++
        }

        return currentLine
    }
}