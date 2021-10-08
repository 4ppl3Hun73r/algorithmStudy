package oct;

import java.util.ArrayList;
import java.util.*;

// https://leetcode.com/problems/word-search/
public class Solution1007 {
    public boolean exist(char[][] board, String word) {
        // Array backtracking matrix
        // bfs or dfs
        // 처음 단어를 찾고, 그 위치에서 시작해서 상하좌우를 계속 탐색
        int[][] dirs = new int[][] {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
        };

        int row = board.length;
        int col = board[0].length;

        List<int[]> startPoint = new ArrayList<>();
        char startCh = word.charAt(0);
        for (int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if (board[i][j] == startCh) {
                    startPoint.add(new int[]{ i, j, 1});
                }
            }
        }

        for (int[] start : startPoint) {
            Queue<WordFinder> queue = new LinkedList<>();
            queue.add(new WordFinder(start[0], start[1], start[2], new boolean[row][col]));

            while(!queue.isEmpty()) {
                WordFinder finder = queue.poll();
                finder.visited[finder.row][finder.col] = true;
                if (finder.findWordPos == word.length()) {
                    return true;
                }
                char findWordCh = word.charAt(finder.findWordPos);

                for(int[] dir : dirs) {
                    int newRow = finder.row + dir[0];
                    int newCol = finder.col + dir[1];

                    if (newRow < 0 || newCol < 0 || newRow == row || newCol == col) {
                        continue;
                    }
                    if (finder.visited[newRow][newCol]) {
                        continue;
                    }
                    if (findWordCh == board[newRow][newCol]) {
                        queue.add(new WordFinder(newRow, newCol, finder.findWordPos + 1, finder.visited)); // 맞나요?
                    }
                    /*
                       AACD
                       ABAF
                       ADAC
                     */
                }
            }
        }

        return false;
    }

    class WordFinder {
        int row;
        int col;
        int findWordPos;
        boolean[][] visited;

        public WordFinder(int row, int col, int findWordPos, boolean[][] visited) {
            this.row = row;
            this.col = col;
            this.findWordPos = findWordPos;
            int vr = visited.length;
            int vc = visited[0].length;
            this.visited = new boolean[vr][vc];
            for (int i = 0; i < vr; i++) {
                for (int j = 0; j < vc; j++) {
                    this.visited[i][j] = visited[i][j];
                }
            }
        }
    }

    // not completed
    public boolean exist2(char[][] board, String word) {

        char[] input = word.toCharArray();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int inputIdx = 0;
                if (board[i][j] == input[inputIdx]
                        && 상하좌우(board, i, j, input, ++inputIdx)) {
                    return true;
                }
            }
        }
        return false;

    }
    private boolean 상하좌우(char[][] board, int i, int j, char[] input, int inputIdx) {

        if (inputIdx == input.length) {
            return true;
        }
        // ABA
        // ABC
        if ((j - 1) >= 0
                && board[i][j - 1] == input[inputIdx]) {
            return 상하좌우(board, i, j - 1, input, ++inputIdx);
        } else if ((j + 1) < board.length
                && board[i][j + 1] == input[inputIdx]) {
            return 상하좌우(board, i, j + 1, input, ++inputIdx);
        } else if ((i - 1) >= 0
                && board[i - 1][j] == input[inputIdx]) {
            return 상하좌우(board, i - 1, j, input, ++inputIdx);
        } else if ((i + 1) < board[0].length
                && board[i + 1][j] == input[inputIdx]) {
            return 상하좌우(board, i + 1, j, input, ++inputIdx);
        } else
            return false;
    }



    public static void main(String[] args) throws Exception {
        Solution1007 s = new Solution1007();

        System.out.println(s.exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'}
        }, "ABCESEEEFS"));  // true

        /*
        * A
        *
        *
        * */
        System.out.println(s.exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        }, "ABCCED")); // true

        /**/
        System.out.println(s.exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        }, "SEE")); // true

        /**/
        System.out.println(s.exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        }, "ABCB")); // false

        System.out.println(s.exist(new char[][]{
                {'a'}
        }, "a")); // true
        System.out.println(s.exist(new char[][]{
                {'a'}
        }, "b")); // false
    }
}
