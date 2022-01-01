package y2021.oct;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/word-search-ii/
public class Solution1009 {
    boolean[][] visited;

    public List<String> findWords(char[][] board, String[] words) {
        // 한 단어는 2번이상 사용할수 없음
        List<String> result = new ArrayList<>();
        for (String word : words) {
            visited = new boolean[board.length][board[0].length];
            if (exist(board, word)) {
                result.add(word);
            }
        }

        return result;
    }

    public boolean exist(char[][] board, String word) {

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if((word.charAt(0) == board[i][j]) && search(board, word, i, j, 0)){
                    return true;
                }
            }
        }

        return false;
    }

    private boolean search(char[][]board, String word, int i, int j, int index){
        if(index == word.length()){
            return true;
        }

        if(i >= board.length || i < 0 || j >= board[i].length || j < 0 || board[i][j] != word.charAt(index) || visited[i][j]){
            return false;
        }

        visited[i][j] = true;
        if(search(board, word, i-1, j, index + 1) ||
                search(board, word, i+1, j, index + 1) ||
                search(board, word, i, j-1, index + 1) ||
                search(board, word, i, j+1, index + 1)) {
            return true;
        }
        visited[i][j] = false;

        return false;
    }

    public static void main(String[] args) {
        Solution1009 s = new Solution1009();


        for (int i = 0; i < 26; i ++) {
            for (int j = 0; j < 26; j ++) {
                for (int k = 0; k < 26; k ++) {
                    System.out.print(String.format("\"%c%c%c%c%c%c%c%c%c%c\",", 'a' + i, 'a' + j, 'a' + k, 'a' + i, 'a' + j, 'a' + k, 'a' + i, 'a' + j, 'a' + k, 'a' + k));
                }
            }
        }



        System.out.println(s.findWords(new char[][]{
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        }, new String[]{"oath","pea","eat","rain","hklf", "hf"}));
        //  ["oath","eat","hklf","hf"]
/*
        System.out.println(s.findWords(new char[][]{
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'}
        }, new String[]{"oath","pea","eat","rain"}));

        System.out.println(s.findWords(new char[][]{
                {'a', 'b'},
                {'c', 'd'}
        }, new String[]{"ab","cd", "ac", "bd", "abcd"}));

        System.out.println(s.findWords(new char[][]{
                {'a', 'a'},
        }, new String[]{"aaa"})); // []*/

    }
}
