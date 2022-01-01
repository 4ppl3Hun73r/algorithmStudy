package y2021.aug;

// https://leetcode.com/explore/featured/card/august-leetcoding-challenge-2021/615/week-3-august-15th-august-21st/3902/
public class Solution0819 {
    public int numDecodings(String s) {
        // 'A' -> 1
        // 'B' -> 2
        // 'Z' -> 26

        // dp[0] -> 모든 케이스를 다 볼수 있어요?


        return 0;
    }

    public static void main(String[] args) {
        Solution0819Kt s = new Solution0819Kt();
        // System.out.println(s.numDecodings("12"));
        //System.out.println(s.numDecodings("27"));
        // System.out.println(s.numDecodings("1201234")); // 3
        // System.out.println(s.numDecodings("2611055971756562"));// 4
        System.out.println(s.numDecodings("111111111111111111111111111111111111111111111"));// time out -> 답: 1836311903
        // 1, 20, 1, 2, 3, 4
        // 1, 20, 12, 3, 4
        // 1, 20, 1, 23, 4

    }

    /////// jiho
    char[] sArr;
    int len;

    public int numDecodings3(String s) {
        // 'A' -> 1
        // 'B' -> 2
        // 'Z' -> 26
        sArr = s.toCharArray();
        len = sArr.length;

        return decode2(0);
    }

    private int decode2(int index) {
        if (index == len) {
            return 1;
        }

        if (index > len) {
            return 0;
        }
        int one = sArr[index] - '0';
        if (one == 0) {
            return 0;
        }
        int cnt = decode2(index + 1);

        if (index + 1 < len) {
            int two = sArr[index + 1] - '0';
            if (one > 2 || (one == 2 && two > 6)) {
                return cnt;
            }
            cnt += decode2(index + 2);
        }

        //System.out.println(String.format("%d, %d", index, cnt));
        return cnt;

    }
    /////--- jiho


    /// ym
    int numDecodings2(String s) {
        return find(s, 0);
    }

    private int find(String s, int idx) {
        int count = 0;
        if (s.length() == 0)
            return 1;
        if (idx == s.length())
            return 0;

        int val = s.charAt(idx) - '0';
        if (val == 0) {
            return 0;
        }

        if (val < 10) {
            String substring = s.substring(idx + 1);
            count += find(substring, 0);
        }

        if (idx < s.length() - 1 && Integer.parseInt(s.substring(idx, idx + 2)) < 27) {
            String substring = s.substring(idx + 2);
            count += find(substring, 0);
        }
        return count;
    }
    /// --- ym

}



