package aug

class Solution0819Kt {
    fun numDecodings(s: String): Int {
        if (s.first() == '0') {
            return 0
        }
        // 112106
        // 1
        // 11
        // 112 -> 1, 1, 2, 1 / 11, 2, 1 / 1, 12, 1
        // 1121 -> dp[1], 0 2
        //
        // dp[n] = 그 자리에서 만들 수 있는 경우의 수 0~n
        // dp[0] = 0 ~ 0 경우의 수
        // dp[1] = 0 ~ 1 경우의 수
        // dp[2] = 0 ~ 2 경우의 수
        // dp[1] = dp[0] + dp[-1] =>
        // dp[n] = fn(dp[n-1], dp[n-2], .. );
        val dp = IntArray(s.length)
        dp[0] = 1
        dp[1] = 1 //

        for (index in 2 until s.length) {
            val char = s[index]
            if (char != '0') {
                // 1 digit
                dp[index] += dp[index - 1]
            }

            // 2 digit
            val twoDigit = Character.getNumericValue(s[index - 1]) * 10 + Character.getNumericValue(s[index])
            if (twoDigit in 10..26) {
                dp[index] += dp[index - 2]
            }
        }

        return dp.last()
    }

    fun numDecodings2(str: String): Int {
        val lenS = str.length
        val dp = IntArray(lenS){ 0 }.also{
            it[0] = if(str[0] == '0') 0 else 1
        }

        for(idx in 1 until lenS){
            val curDigit = str[idx] - '0'
            if(curDigit != 0){
                dp[idx] += dp[idx - 1]
            }

            val prevDigit = (str[idx - 1] - '0') * 10 + curDigit
            if(prevDigit in 10..26){
                dp[idx] += if(idx >= 2) dp[idx - 2] else 1
            }
        }

        return dp[lenS - 1]
    }

    fun numDecodings1(s: String): Int {
        val dp = IntArray(s.length + 1)
        dp[0] = 1
        dp[1] = if (s[0] == '0') 0 else 1

        for (i in 2 until s.length + 1) {
            val cur = s[i-1]
            if (cur != '0') {
                dp[i] = dp[i-1]
            }

            val pre = s[i-2]
            val result = (10*(pre - '0') + (cur - '0'))
            if (result in 10..26) {
                dp[i] += dp[i-2]
            }
        }

        return dp[s.length]
    }
}

