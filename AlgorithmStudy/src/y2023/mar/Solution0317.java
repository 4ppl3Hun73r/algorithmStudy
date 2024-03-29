package y2023.mar;

// https://leetcode.com/problems/implement-trie-prefix-tree/
public class Solution0317 {
}

class Trie {

    class TrieNode {
        private TrieNode[] childs;
        private boolean isEnd;

        public TrieNode() {
            childs = new TrieNode[26];
        }

        public boolean containsKey(char ch) {
            return childs[ch - 'a'] != null;
        }
        public TrieNode get(char ch) {
            return childs[ch - 'a'];
        }
        public void put(char ch, TrieNode node) {
            childs[ch - 'a'] = node;
        }
        public void setEnd() {
            isEnd = true;
        }
        public boolean isEnd() {
            return isEnd;
        }
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (!node.containsKey(currentChar)) {
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar);
        }
        node.setEnd();
    }

    public boolean search(String word) {
        TrieNode node = searchPrefix(word);

        return node != null && node.isEnd();
    }

    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char curLetter = word.charAt(i);
            if (node.containsKey(curLetter)) {
                node = node.get(curLetter);
            } else {
                return null;
            }
        }
        return node;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }
}