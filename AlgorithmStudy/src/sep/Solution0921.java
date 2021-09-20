package sep;

// https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/638/week-3-september-15th-september-21st/3981/
public class Solution0921 {

    public String tictactoe(int[][] moves) {
        int[][] tictactoe = new int[3][3];

        int player = 1;
        for (int[] move : moves) {
            tictactoe[move[0]][move[1]] = player;
            if (player == 1)
                player = 2;
            else
                player = 1;
        }

        int winner = 0;
        // 가로 검사
        for (int i = 0 ; i < 3; i++) {
            if (tictactoe[i][0] == tictactoe[i][1] && tictactoe[i][0] == tictactoe[i][2]) {
                winner = tictactoe[i][0];
                break;
            }
        }
        if (winner == 0) {
            // 세로 검사
            for (int i = 0 ; i < 3; i++) {
                if (tictactoe[0][i] == tictactoe[1][i] && tictactoe[0][i] == tictactoe[2][i]) {
                    winner = tictactoe[0][i];
                    break;
                }
            }
        }
        if (winner == 0) {
            // 대각선 검사
            if (tictactoe[0][0] == tictactoe[1][1] && tictactoe[0][0] == tictactoe[2][2]) {
                winner = tictactoe[0][0];
            }
            if (tictactoe[2][0] == tictactoe[1][1] && tictactoe[2][0] == tictactoe[0][2]) {
                winner = tictactoe[2][0];
            }
        }

        if (winner == 0) {
            return moves.length == 9 ? "Draw" : "Pending";
        }

        return winner == 1 ? "A" : "B";
    }

}
