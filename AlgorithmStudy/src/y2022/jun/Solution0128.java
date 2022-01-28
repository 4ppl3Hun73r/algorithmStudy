package y2022.jun;


// https://leetcode.com/problems/design-add-and-search-words-data-structure/
public class Solution0128 {
}


class WordDictionary {
    Trie root;

    public WordDictionary() {
        root = new Trie();
    }

    public void addWord(String word) {
        Trie node = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new Trie();
            }
            node = node.children[idx];
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        return search(0, word.toCharArray(), root);
    }

    private boolean search(int idx, char[] charArr, Trie node) {
        for (int i = idx; i < charArr.length; i++) {
            char ch = charArr[i];
            if (ch == '.') {
                for (int j = 0; j < 26; j++) {
                    if (node.children[j] != null) {
                        boolean result = search(i + 1, charArr, node.children[j]);
                        if (result) {
                            return true;
                        }
                    }
                }
                return false;
            } else {
                int t = ch - 'a';
                if(node.children[t] == null) {
                    return false;
                }
                node = node.children[t];
            }
        }

        return node.isWord;
    }


    class Trie {
        Trie[] children;
        boolean isWord;

        public Trie() {
            children = new Trie[26];
            isWord = false;
        }
    }
}