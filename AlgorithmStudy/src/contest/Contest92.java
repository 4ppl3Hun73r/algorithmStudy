package contest;

import java.util.HashMap;
import java.util.Map;

public class Contest92 {


    public static void main(String[] args) {
        Contest92 c = new Contest92();

    }
}


class Encrypter {

    Map<Character, String> keyValueMap = new HashMap<>();
    Map<String, Integer> encryptCntMap = new HashMap<>();

    public Encrypter(char[] keys, String[] values, String[] dictionary) {
        for (int i = 0; i < keys.length; i++) {
            keyValueMap.put(keys[i], values[i]);
        }

        for (String s : dictionary) {
            String enc = this.encrypt(s);
            encryptCntMap.put(enc, encryptCntMap.getOrDefault(enc, 0) + 1);
        }
    }

    public String encrypt(String word1) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < word1.length(); i++) {
            sb.append(keyValueMap.get(word1.charAt(i)));
        }

        return sb.toString();
    }

    public int decrypt(String word2) {
        return encryptCntMap.getOrDefault(word2, 0);
    }
}

/**
 * Your Encrypter object will be instantiated and called as such:
 * Encrypter obj = new Encrypter(keys, values, dictionary);
 * String param_1 = obj.encrypt(word1);
 * int param_2 = obj.decrypt(word2);
 */