package y2022.jun;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/longest-string-chain/
public class Solution0615 {
    Map<Integer, Integer> cache = new HashMap<>();
    public int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        //System.out.println(Arrays.deepToString(words));

        int result = Integer.MIN_VALUE;
        for (int i = 0; i < words.length; i++) {
            result = Math.max(helper(words, i), result);
        }

        return result;
    }

    private int helper(String[] words, int idx) {
        if (cache.containsKey(idx)) {
            return cache.get(idx);
        }

        String word = words[idx];
        int chain = 1;
        int nextChainLen = word.length() + 1;
        for (int i = idx + 1; i < words.length; i++) {
            if (nextChainLen == words[i].length()) {
                if (validation(word, words[i])) {
                    System.out.println(word + "->" + words[i]);
                    chain = Math.max(chain, helper(words, i) + 1);
                }
            } else if (words[i].length() > nextChainLen) {
                break;
            }
        }
        cache.put(idx, chain);

        return chain;
    }

    private boolean validation(String word1, String word2) {
        int w1Left = 0;
        int w1Right = word1.length() - 1;

        int w2Left = 0;
        int w2Right = word2.length() - 1;

        int skip = 0;

        while (w2Left <= w2Right) {
            if (skip == 2) {
                break;
            }
            if (word1.charAt(w1Left) != word2.charAt(w2Left)) {
                skip++;
                w2Left++;
                continue;
            }
            if (word1.charAt(w1Right) != word2.charAt(w2Right)) {
                skip++;
                w2Right--;
                continue;
            }

            w1Left++;
            w2Left++;
            w1Right--;
            w2Right--;
        }
        if (skip == 2) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) throws Exception {
        Solution0615 s = new Solution0615();

        //System.out.println(s.longestStrChain(new String[]{"xbc","pcxbcf","xb","cxbc","pcxbc"}));
        System.out.println(s.longestStrChain(new String[]{"qyssedya","pabouk","mjwdrbqwp","vylodpmwp","nfyqeowa","pu","paboukc","qssedya","lopmw","nfyqowa","vlodpmw","mwdrqwp","opmw","qsda","neo","qyssedhyac","pmw","lodpmw","mjwdrqwp","eo","nfqwa","pabuk","nfyqwa","qssdya","qsdya","qyssedhya","pabu","nqwa","pabqoukc","pbu","mw","vlodpmwp","x","xr"}));
    }
}
