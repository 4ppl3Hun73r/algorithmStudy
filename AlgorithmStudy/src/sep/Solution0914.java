package sep;

// https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/637/week-2-september-8th-september-14th/3973/
public class Solution0914 {

    public int maxNumberOfBalloons(String text) {
        // balloon
        int min = 0;
        // Map : balloon ->
        // int[] => new int[26];
        int b;
        int a;
        int l;
        int o;
        int n;

        return min;
    }

    public int jiho(String text) {
        int min = 0;
        int[] alphabet = new int[26];

        for (char c : text.toCharArray()) {
            alphabet[c - 'a']++;
        }

        min = Math.min(alphabet[0], alphabet[1]); // a, b
        min = Math.min(min, alphabet[13]); // n
        min = Math.min(min, alphabet[11] / 2);
        min = Math.min(min, alphabet[14] / 2);

        return min;
    }

    /*
        fun maxNumberOfBalloons(text: String): Int {
            val balloon = "balloon".toCharArray()
            val dict = mutableMapOf<Char, Int>()

            for (c in balloon) {
                dict[c] = 0
            }
            for (c in text) {
                if (c in dict.keys) {
                    dict[c] = dict[c]!! + 1
                }
            }

            dict['l'] = dict['l']!! / 2
            dict['o'] = dict['o']!! / 2

            return dict.values.min() ?: 0
        }

     */
}
