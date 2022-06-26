package y2022.jun;

import java.util.Comparator;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

// https://leetcode.com/problems/prefix-and-suffix-search/
public class Solution0618 {

    public static void main(String[] args) {
        WordFilter w = new WordFilter(new String[]{"apple"});

        System.out.println(w.f("a", "e")); // return 0;

        /*
        ["WordFilter","f","f","f","f","f","f","f","f","f","f"]
[[["cabaabaaaa","ccbcababac","bacaabccba","bcbbcbacaa","abcaccbcaa","accabaccaa","cabcbbbcca","ababccabcb","caccbbcbab","bccbacbcba"]],["bccbacbcba","a"],["ab","abcaccbcaa"],["a","aa"],["cabaaba","abaaaa"],["cacc","accbbcbab"],["ccbcab","bac"],["bac","cba"],["ac","accabaccaa"],["bcbb","aa"],["ccbca","cbcababac"]]
         */
        w = new WordFilter(new String[]{"cabaabaaaa","ccbcababac","bacaabccba","bcbbcbacaa","abcaccbcaa","accabaccaa","cabcbbbcca","ababccabcb","caccbbcbab","bccbacbcba"});
        System.out.println(w.f("ab","abcaccbcaa")); // return 4;

        Random r = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 15000; i++) {
            for (int j = 0; j < 10; j++) {
                sb.append((char)('a' + r.nextInt(26)));
            }
            System.out.print("\"" + sb.toString() + "\",");
            sb.delete(0, 10);
        }
    }
}

class WordFilter {
    Trie prefixRoot;
    Trie suffixRoot;

    public WordFilter(String[] words) {
        /*
        {prefix}xxxxxxx{suffix} 로 이루어진 word 의 index (0 base) 를 찾아서 반환
        word가 여러개면 가장 큰 word 반환
        word가 없으면 -1 반환
         */

        prefixRoot = new Trie();
        suffixRoot = new Trie();

        for (int x = 0; x < words.length; x++) {
            String word = words[x];
            Trie node = prefixRoot;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (node.next[ch - 'a'] == null) {
                    node.next[ch - 'a'] = new Trie();
                }
                node = node.next[ch - 'a'];
                node.idxSet.add(x);
            }
            node.word = true;

            node = suffixRoot;
            for (int i = word.length() - 1; i >= 0; i--) {
                char ch = word.charAt(i);
                if (node.next[ch - 'a'] == null) {
                    node.next[ch - 'a'] = new Trie();
                }
                node = node.next[ch - 'a'];
                node.idxSet.add(x);
            }
            node.word = true;
        }

        //System.out.println(prefixRoot);
        //System.out.println(suffixRoot);
    }

    public int f(String prefix, String suffix) {
        // {prefix} 까지 Trie 탐색, 그 이하에 있는 모든 isWord == true 는 prefix 대상
        // suffix 가 있는지 찾기 위해서 최적의 검색 법?
        // {suffix} 로 시작하는 모든 단어 목록을 찾기

        Trie node = prefixRoot;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            node = node.next[ch - 'a'];
            if (node == null) {
                break;
            }
        }
        Set<Integer> prefixSet = node !=null ? node.idxSet : null;

        node = suffixRoot;
        for (int i = suffix.length() - 1; i >= 0; i--) {
            char ch = suffix.charAt(i);
            node = node.next[ch - 'a'];
            if (node == null) {
                break;
            }
        }
        Set<Integer> suffixSet = node !=null ? node.idxSet : null;
        if (suffixSet == null || prefixSet == null) {
            return -1;
        }


        for (Integer idx : prefixSet) {
            if (suffixSet.contains(idx)) {
                return idx;
            }
        }

        return -1;
    }

    class Trie {
        Trie[] next = new Trie[26];
        boolean word;
        Set<Integer> idxSet = new TreeSet<>(Comparator.reverseOrder());
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */