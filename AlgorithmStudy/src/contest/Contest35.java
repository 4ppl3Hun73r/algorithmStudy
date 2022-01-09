package contest;

import java.util.HashSet;
import java.util.Set;

public class Contest35 {
    public int wordCount(String[] startWords, String[] targetWords) {

        /*
        startWord 에 글자 하나를 붙이고 재 배열해서 targetWord 가 나오면 +1
         */

        int[] bitMap = new int[26];
        int s = 1;
        for (int i = 0; i < 26; i++) {
            bitMap[i] = s;
            s *= 2;
        }

        Set<Integer> startBitSet = new HashSet<>();
        for (int i = 0; i < startWords.length; i++) {
            String startWord = startWords[i];
            int bit = 0;
            for (int j = 0; j < startWord.length(); j++) {
                char ch = startWord.charAt(j);
                bit = bit | bitMap[ch - 'a'];
            }
            startBitSet.add(bit);
        }
        int result = 0;

        for (int i = 0; i < targetWords.length; i++) {
            String targetWord = targetWords[i];
            int bit = 0;
            for (int j = 0; j < targetWord.length(); j++) {
                char ch = targetWord.charAt(j);
                bit = bit | bitMap[ch - 'a'];
            }

            int temp = bit;
            for (int j = 0; j < targetWord.length(); j++) {
                char ch = targetWord.charAt(j);
                bit = bit ^ bitMap[ch - 'a'];
                if (startBitSet.contains(bit)) {
                    result++;
                    break;
                }
                bit = temp;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Contest35 c = new Contest35();

        System.out.println(c.wordCount(new String[]{"ant","act","tack"}, new String[]{"tack","act","acti"}));

        System.out.println(c.wordCount(new String[]{"ab","a"}, new String[]{"abc","abcd"}));

    }
}
