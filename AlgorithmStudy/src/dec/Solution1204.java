package dec;

import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/stream-of-characters/
public class Solution1204 {
    /*

    ["StreamChecker","query","query","query","query","query","query","query","query","query","query","query","query"]
    [[["abc","xyz"]],["a"],["x"],["y"],["z"],["b"],["c"],["a"],["d"],["d"],["e"],["k"],["l"]]
    ["StreamChecker","query","query","query","query","query","query","query","query","query","query","query","query"]
    [[["cd","f","kl"]],["a"],["b"],["c"],["d"],["e"],["f"],["g"],["h"],["i"],["j"],["k"],["l"]]

            a     x     y    z     b     c      a     d     d     e     k     l
    [null,false,false,false,true,false,false,false,false,false,false,false,false]

            a     b     c    d     e    f     g    h      i     j     k     l
    [null,false,false,false,true,false,true,false,false,false,false,false,true]
    [[abc, xyz]]
             r
         c        z
         b        y
         a        x
     a -> false
     xa -> false
     yxa -> false
     zyxa ->  true
     bzyxa -> false
     cbzyxa -> false
     acbzyxa -> false

     [cd, f, kl]
             r
         d   f  l
         c      k
     a -> false
     ba -> false
     cba -> false
     dcba -> find d -> find c -> c is word -> true
     edcba -> false
     fedcba -> find f -> f is word -> true
     gfedcba -> false
     hgfedcba -> false
     lkjihgfedcba -> find l -> find k -> k is word -> true

     */
}

class StreamChecker {
    Trie root;
    List<Character> list;

    public StreamChecker(String[] words) {
        root = new Trie();
        list = new LinkedList<>();

        for (String word : words) {
            Trie node = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                char ch = word.charAt(i);
                if (node.next[ch - 'a'] == null) {
                    node.next[ch - 'a'] = new Trie();
                }
                node = node.next[ch - 'a'];
            }
            node.word = true;
        }
    }

    public boolean query(char letter) {
        list.add(letter);
        Trie node = root;

        for (int i = list.size() - 1; i >= 0; i--) {
            char ch = list.get(i);
            node = node.next[ch - 'a'];

            if (node == null) {
                break;
            }

            if (node.word) {
                return true;
            }
        }
        return false;
    }

    class Trie {
        Trie[] next = new Trie[26];
        boolean word;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */