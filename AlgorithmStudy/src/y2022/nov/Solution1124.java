package y2022.nov;


// https://leetcode.com/problems/word-search/
public class Solution1124 {
    public boolean exist(char[][] board, String word) {
        /*
        [["A","B","C","E"],
         ["S","F","C","S"],
         ["A","D","F","E"]]

         [set0, set1, set2, set3]
         [set, set, set3, set2]
         [set, set, set4, set1]
         [set, set, set, set0]
         */
        char[] words = word.toCharArray();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++){
                if (dfs(board, words, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, char[] words, int i, int j, int idx) {
        if ( idx == words.length) {
            return true;
        }
        if (i < 0 || j < 0 || i == board.length || j == board[0].length) {
            return false;
        }
        if (board[i][j] != words[idx]) {
            return false;
        }

        char tmp = board[i][j];
        board[i][j] = '*';

        boolean exist = dfs(board, words, i + 1, j, idx + 1) || dfs(board, words, i -1, j, idx + 1)
                || dfs(board, words, i, j+1, idx + 1) || dfs(board, words, i, j - 1, idx + 1);

        board[i][j] = tmp;

        return exist;
    }
}
