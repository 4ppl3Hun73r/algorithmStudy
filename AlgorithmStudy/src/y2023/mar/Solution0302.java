package y2023.mar;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/string-compression/
public class Solution0302 {
    public int compress(char[] chars) {
        int compressIdx = 0;
        Character current = null;
        int count = 1;

        for (int i = 0; i < chars.length; i++) {
            if (current == null) {
                current = chars[i];
                continue;
            }
            if (current != chars[i]) {
                chars[compressIdx++] = current;
                current = chars[i];
                if (count != 1) {
                    for (char c : String.valueOf(count).toCharArray()) {
                        chars[compressIdx++] = c;
                    }
                }
                count = 1;
            } else {
                count++;
            }
        }
        chars[compressIdx++] = current;
        if (count != 1) {
            for (char c : String.valueOf(count).toCharArray()) {
                chars[compressIdx++] = c;
            }
        }

        return compressIdx;
    }

    public int compressList(char[] chars) {
        int compressIdx = 0;
        char current = '_';
        int count = 1;

        List<Character> testList = new ArrayList<>();
        // a b b
        for (int i = 0; i < chars.length; i++) {
            if (current != chars[i]) {
                testList.add(chars[i]);
                if (count != 1) {
                    for (char c : String.valueOf(count).toCharArray()) {
                        testList.add(c);
                    }
                }
                current = chars[i];
                count = 1;
            } else {
                count++;
            }
        }
        if (count != 1) {
            for (char c : String.valueOf(count).toCharArray()) {
                testList.add(c);
            }
        }

        System.out.println(testList);
        compressIdx = testList.size();
        return compressIdx;
    }

    public static void main(String[] args) throws Exception {
        Solution0302 s = new Solution0302();

//        System.out.println(s.compress(new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'}));
        System.out.println(s.compress(new char[]{'a','a','b','b','c','c','c'}));
    }
}
