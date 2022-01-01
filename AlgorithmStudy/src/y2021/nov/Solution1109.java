package y2021.nov;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/number-of-valid-words-for-each-puzzle/
public class Solution1109 {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        List<Integer> result = new ArrayList<>();
        // hash table, string, bit manipulation, Trie
        /*
          조건
          - 퍼즐에 몇개의 단어가 속하는지
          - 퍼즐의 첫번째 char가 워드에 있어야함 p : abcd w : bcd -> false / w : acd -> true
         */

        /*
        words :     ["aaaa",    "asas",     "able",     "ability",  "actt",     "actor",    "access"]
        words :     [ 0000,    "asas",     "able",     "ability",  "actt",     "actor",    "access"]
        puzzles:    ["aboveyz", "abrodyz",  "abslute",  "absoryz",  "actresz",  "gaswxyz"]
        Output:     [1,          1,         3,          2,            4,            0]

        puzzles max 7
        word max 50
         */

        boolean[] alphabet = new boolean[26];
        // word1 : [t,f,f,f,f,f...f] -> 00000000001  <- aaaa
        // word2 : [t,,,,,,,,,t,,..] -> 00001000001  <- asas
        // 00000000001 -> 공통은 a ->
        int[] bits = new int[26];
        for (int i = 0; i < 26; i++) {
            bits[i] = (int)Math.pow(2, i);
            /*
            a -> 1    bit[0 'a'] = 0000000001
            b -> 2    0000000010
            c -> 4    0000000100
            d -> 8    0000001000
            e -> 16   0000010000
            ...
             */
        }

        int[] puzzlesBit = new int[puzzles.length];
        for (int i = 0; i < puzzlesBit.length; i++) {
            for(char c : puzzles[i].toCharArray()) {
                puzzlesBit[i] = puzzlesBit[i] | bits[c - 'a'];
            }
        }
        int[] wordsBit = new int[words.length];
        for (int i = 0; i < wordsBit.length; i++) {
            for(char c : words[i].toCharArray()) {
                wordsBit[i] = wordsBit[i] | bits[c - 'a'];
            }
        }

        for (int i = 0; i < puzzles.length; i++) {
            int count = 0;
            int puzzlesFirstBit = bits[puzzles[i].charAt(0) - 'a'];
            int puzzleBit = puzzlesBit[i];
            for (int j = 0; j < words.length; j++) {
                int wordBit = wordsBit[j];
                if ((puzzleBit & wordBit) == wordBit
                        && (puzzlesFirstBit & wordBit) == puzzlesFirstBit) {
                    count++;
                }
            }
            result.add(count);
        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        Solution1109 s = new Solution1109();
        System.out.println(
          s.findNumOfValidWords(new String[]{"aaaa","asas","able","ability","actt","actor","access"},
                  new String[]{"aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"})
        ); // [1,1,3,2,4,0]
        System.out.println(
                s.findNumOfValidWords(new String[]{"apple","pleas","please"},
                        new String[]{"aelwxyz","aelpxyz","aelpsxy","saelpxy","xaelpsy"})
        ); // [0,1,3,2,0]
    }
}
