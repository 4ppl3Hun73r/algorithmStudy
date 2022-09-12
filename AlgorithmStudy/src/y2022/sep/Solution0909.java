package y2022.sep;

import java.util.Arrays;

// https://leetcode.com/problems/the-number-of-weak-characters-in-the-game/
public class Solution0909 {
    public int numberOfWeakCharacters(int[][] properties) {
        /*
        properties[2] = [attack, defense]
        다른 하나의 prop 보다 att, def 가 낮으면 weak characters

        2중 for 로 바로 찾을 수 있음
         */
        Arrays.sort(properties, (a, b) -> {
            if ( a[0] == b[0] ) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        System.out.println(Arrays.deepToString(properties));

        int max = Integer.MIN_VALUE;
        int ans = 0;

        for (int i = properties.length - 1; i >= 0; i--)
        {
            if (properties[i][1] < max) {
                ans++;
            }
            max = Math.max(max, properties[i][1]);
        }
        return ans;
    }

    public static void main(String[] args) {

        Solution0909 s = new Solution0909();

        System.out.println(s.numberOfWeakCharacters(new int[][]{{1,5}, {10,4}, {4,3}}));
        System.out.println(s.numberOfWeakCharacters(new int[][]{{1,5}, {10,4}, {4,3}, {1,4}, {1,1}}));
    }
}
