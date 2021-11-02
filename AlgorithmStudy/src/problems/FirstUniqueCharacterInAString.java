package problems;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        Map<Character, int[]> charMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!charMap.containsKey(i)) {
                charMap.put(c, new int[]{i, 1});
            } else {
                int[] counter = charMap.get(c);
                counter[0] = i;
                counter[1]++;
                charMap.put(c, counter);
            }
        }

        int result = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int[] counter = charMap.get(c);
            if (counter[1] == 1) {
                result = i;
                break;
            }
        }

        return result;
    }
}
