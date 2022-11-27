package y2022.nov;


import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/word-search-ii/
public class Solution1105 {


    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        Trie root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs (board, i, j, root, res);
            }
        }
        return res;


    }

    private void dfs(char[][] board, int i, int j, Trie trie, List<String> res) {
        char c = board[i][j];
        if (c == '#' || trie.next[c - 'a'] == null){
            return ;
        }
        trie = trie.next[c - 'a'];
        if (trie.word != null) {
            res.add(trie.word);
            trie.word = null;
        }

        board[i][j] = '#';
        if (i > 0) {
            dfs(board, i - 1, j ,trie, res);
        }
        if (j > 0) {
            dfs(board, i, j - 1, trie, res);
        }
        if (i < board.length - 1) {
            dfs(board, i + 1, j, trie, res);
        }
        if (j < board[0].length - 1) {
            dfs(board, i, j + 1, trie, res);
        }
        board[i][j] = c;
    }

    private Trie buildTrie(String[] words) {
        Trie root = new Trie();
        for (String w : words) {
            Trie trie = root;
            for (char c : w.toCharArray()) {
                int i = c - 'a';
                if (trie.next[i] == null) {
                    trie.next[i] = new Trie();
                }
                trie = trie.next[i];
            }
            trie.word = w;
        }
        return root;
    }


    class Trie {
        Trie[] next = new Trie[26];
        String word;
    }
}
