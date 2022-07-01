package y2022.jun;

// https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/
public class Solution0627 {
    public int minPartitions(String n) {
        /*
        deci-binary : 101, 11, 111 같이 0, 1 로만 이루어진 수
        최소한의 양의 deci-binary 들의 합으로 n 을 만들때 "최소한" 의 수 반환

        n 은 100000 자리의 수

        32
        11
        11
        10 -> 3

        82734
        11111
        11111
        10111
        10101
        ..

        27346209830709182346  -> 9
        10000001000000000000
        10000001000000000000
        01000001000000000000
        01000001000000000000
        01000001000000000000
        000000001000000000000
        00000001000000000000
        ...

         */
        int ans = 0;

        for (int i = 0; i < n.length(); i++) {
            char c = n.charAt(i);

            ans = Math.max(ans, c - '0');
        }

        return ans;

    }
}
