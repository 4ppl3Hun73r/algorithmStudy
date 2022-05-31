package y2022.may;

public class Solution0529 {

    public int maxProduct(String[] words) {

        int len = words.length;
        int[] bits = new int[len];
        for (int i = 0; i < len; i++) {
            String word = words[i];
            int bit = 0;
            for (int j = 0; j < word.length(); j++) {
                bit |= 1 << (word.charAt(j) - 'a');
            }
            bits[i] = bit;
        }

        int max = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if ((bits[i] & bits[j]) != 0) {
                    continue;
                }
                max = Math.max(max, words[i].length() * words[j].length());
            }
        }


        return max;
    }
}
