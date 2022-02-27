package contest;

import java.util.Arrays;

public class Contest74 {

    public int minSteps(String s, String t) {
        int[] map = new int[26];

        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            map[t.charAt(i) - 'a']--;
        }

        int ans = 0;
        for (int i = 0; i < map.length; i++) {
            if ( map[i] != 0) {
                ans += Math.abs(map[i]);
            }
        }
        System.out.println(Arrays.toString(map));

        return ans;
    }

    public static void main(String[] args) {
        Contest74 c = new Contest74();

        c.minSteps("leetcode", "coats");
    }
}
