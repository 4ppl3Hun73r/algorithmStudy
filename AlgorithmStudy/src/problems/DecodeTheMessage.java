package problems;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/decode-the-message/
public class DecodeTheMessage {
    public String decodeMessage(String key, String message) {

        Map<Character, Character> keyAlphabetMap = new HashMap<>();

        keyAlphabetMap.put(' ', ' ');
        char alphabet = 'a';
        for (int i = 0; i < key.length(); i++) {
            char ch = key.charAt(i);

            if (!keyAlphabetMap.containsKey(ch)) {
                keyAlphabetMap.put(ch, alphabet++);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            sb.append(keyAlphabetMap.get(message.charAt(i)));
        }

        return sb.toString();

    }
}
