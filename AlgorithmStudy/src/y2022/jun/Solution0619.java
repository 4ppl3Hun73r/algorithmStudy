package y2022.jun;


import java.util.*;

// https://leetcode.com/problems/search-suggestions-system/
public class Solution0619 {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie root = new Trie();

        Arrays.sort(products);
        for (int i = 0; i < products.length; i++) {
            String product = products[i];
            Trie node = root;
            for (int j = 0; j < product.length(); j++) {
                char ch = product.charAt(j);
                if (node.next[ch - 'a'] == null) {
                    node.next[ch - 'a'] = new Trie();
                }
                node = node.next[ch - 'a'];
                node.idxSet.add(i);
            }
        }

        List<List<String>> ans = new ArrayList<>();

        Trie node = root;
        for (int i = 0; i < searchWord.length(); i++) {
            List<String> r = new ArrayList<>();

            char ch = searchWord.charAt(i);
            if (node == null) {
                ans.add(r);
                continue;
            }
            node = node.next[ch - 'a'];
            if (node == null) {
                ans.add(r);
                continue;

            }
            int cnt = 0;
            for (Integer idx : node.idxSet) {
                if (cnt == 3) {
                    break;
                }
                r.add(products[idx]);
                cnt++;
            }
            ans.add(r);
        }

        return ans;
    }



    class Trie {
        Trie[] next = new Trie[26];
        boolean word;
        Set<Integer> idxSet = new TreeSet<>();
    }
}
