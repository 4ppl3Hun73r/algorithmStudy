package sep;

import java.util.Arrays;

// https://leetcode.com/explore/featured/card/september-leetcoding-challenge-2021/636/week-1-september-1st-september-7th/3964/
public class Solution0906 {
    public String orderlyQueue(String s, int k) {

        // [abcd]
        if (k == 1) {
            // abcdabcd
            // bcda
            // cdab
            // dabc
            // -> 비교해서, 가장 작은걸 하면 되지 않을까?
            String result = s;
            for (int i = 1; i < s.length(); i++) {
                String s2 = s.substring(i) + s.substring(0, i);
                if (result.compareTo(s2) > 0) {
                    result = s2;
                }
            }
            return result;
        } else {
            char[] sortArr = s.toCharArray();
            Arrays.sort(sortArr);
            return new String(sortArr);
        }
    }
}

// b... bbbb
