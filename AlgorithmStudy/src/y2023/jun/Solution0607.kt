package y2023.jun

class Solution0607 {
    fun minFlips(a: Int, b: Int, c: Int): Int {

        // a or b => c
        // a , b flip
        val binaryA = a.toString(2).reversed()
        val binaryB = b.toString(2).reversed()
        val binaryC = c.toString(2).reversed()

        val maxLen = Math.max(binaryA.length, Math.max(binaryB.length, binaryC.length))

        var flip = 0
        for ( i in 0 until maxLen) {
            val bitA: Char = if (i < binaryA.length) binaryA[i] else '0'
            val bitB: Char = if (i < binaryB.length) binaryB[i] else '0'
            val bitC: Char = if (i < binaryC.length) binaryC[i] else '0'

            if (bitC == '0') {
                if (bitA == '1' && bitB == '1') {
                    flip += 2
                } else if (bitA == '1' || bitB == '1') {
                    flip += 1
                }
            } else {
                if (bitA == '0' && bitB == '0') {
                    flip += 1
                }
            }
        }


        println(binaryA)
        println(binaryB)
        println(binaryC)

        return flip
    }
}

fun main() {
    val s = Solution0607()

    println(s.minFlips(2, 6, 5))
}