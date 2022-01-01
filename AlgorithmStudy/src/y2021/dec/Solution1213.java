package y2021.dec;

// https://leetcode.com/problems/consecutive-characters/
public class Solution1213 {
    public int maxPower(String s) {
        /*
            leetcode -> ee -> 2
            hooraaaaaaaaaaay -> aaaaaaaaaaa -> 11
            abbcccddddeeeeedcba -> bb/ccc/dddd/**eeeee** -> 5
         */
        int power = 1;
        char prev = s.charAt(0);
        int t = 1;
        for (int i = 1; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (prev == ch) {
                t++;
            } else {
                t = 1;
            }
            prev = ch;
            power = Math.max(power, t);
        }

        return power;
    }

    public static void main(String[] args) throws Exception {
        Solution1213 s = new Solution1213();

        System.out.println(s.maxPower("leetcode"));
        System.out.println(s.maxPower("hooraaaaaaaaaaay"));
        System.out.println(s.maxPower("abbcccddddeeeeedcba"));
        System.out.println(s.maxPower("j"));
    }

}
