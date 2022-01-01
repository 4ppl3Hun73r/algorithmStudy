package y2021.aug;

// https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/614/week-2-august-8th-august-14th/3876/
public class Solution0811 {

    public int minFlipsMonoIncr(String s) {
        // 최소한의 수를 뒤집어서(0 -> 1, 1 -> 0) 한번만 증가하는 배열(?)을 만듬
        // "000001" => 0
        // "010110" => 2
        // "00011000" => 2
        // "0101100011" => 3
        // "01011000101"답=> 4
        // dp[i][j] => 답
        //  00111233344 => 4
        // dp 에 약합니다.
        // "01011000101"
        //      i     j
        // dp[0][0] => 0
        // dp[0][1] => 1
        // dp[0][2] => 1 => min(dp[0][0] + dp[0][2])
        // dp[0][n] => 답
        // dp[0][n] == 1 => dp[0][n-1]
        /*
         구현
          1. 0 을 만나면 그동안 앞에 있는 1의 숫자가 flip 수 => min(1의 숫자, 최초 1이 시작한 이래로부터 0개수)
          2. 1 을 만나면 1 ~ 다음 1까지 의 0의 숫자? => 앞에 답
         */

        // '1', '0' -> 0
        // "10011111110010111011" =>  답5 => 우리꺼6
        //  01111111112334444555 -> flip 변수으 변화
        //            Min(앞에있는 1의 숫자, 지금까지 계산한 flip의수)
        int flip = 0;
        int countOne = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                countOne ++;
            } else {
                flip ++;
            }
            flip = Math.min(flip, countOne);
        }

//
//        int startIdx = -1;
//        int countZero = 0;
//        int countOne = 0;
//
//        for (int i = 0; i < s.length(); i++) {
//            if (startIdx < 0 && s.charAt(i) == '1') {
//                startIdx = i;
//            }
//            if (startIdx >= 0) {
//                if (s.charAt(i) == '1') {
//                    countOne++;
//                } else {
//                    countZero++;
//                }
//            }
//        }
//
//        return Math.min(countOne, countZero);
        return flip;
    }

    public int minFlipsMonoIncr2(String s) {
        int count = 0;
		String temp = s;

		while (temp.contains("10")) {
			temp = temp.replaceFirst("10", ""); // 검색 비용 N < => N2
			count++;
		}

		return count;
    }

    /**
     * solution
     * https://leetcode.com/problems/flip-string-to-monotone-increasing/solution/
     * @param S
     * @return
     */
    public int minFlipsMonoIncr3(String S) {
        int N = S.length();
        int[] P = new int[N + 1];
        for (int i = 0; i < N; ++i)
            P[i+1] = P[i] + (S.charAt(i) == '1' ? 1 : 0);

        int ans = Integer.MAX_VALUE;
        for (int j = 0; j <= N; ++j) {
            ans = Math.min(ans, P[j] + N-j-(P[N]-P[j]));
        }
        return ans;
    }
}
