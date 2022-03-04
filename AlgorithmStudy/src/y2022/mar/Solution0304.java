package y2022.mar;

import java.util.Arrays;

// https://leetcode.com/problems/champagne-tower/
public class Solution0304 {
    public double champagneTower(int poured, int query_row, int query_glass) {
        // pured 만큼 샴페인을 부은후 r / c (query_row, query_glass) 의 샴페인 잔이 얼마나 차 있는지 구하기
        // r / c 0 base index
        // MAIN 에 테스트 용으로 만들었는데 1씩 붓는게 아니라 한번에 다 부으면 될것 같음

        double[][] tower = new double[101][101];
        tower[0][0] += poured;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (tower[i][j] > 1.0f) {
                    double over = (tower[i][j] - 1.0f) / 2;
                    tower[i + 1][j] += over;
                    tower[i + 1][j + 1] += over;
                    tower[i][j] = 1.0f;
                }
            }
        }

        return tower[query_row][query_glass];
    }
    
    
    public static void main(String[] args) throws Exception {
        double[][] tower = new double[100][100];

        int poured = 100;
        for (int i = 0; i < poured; i++) {
            double p = 1.0f;
            int start = 0;
            boolean isOver = true;
            tower[0][0] += p;
            while (isOver) {
                isOver = false;
                for (int j = 0; j < start + 1; j++) {
                    if (tower[start][j] > 1.0f) {
                        if (start != 99) {
                            double over = tower[start][j] - 1.0f;
                            tower[start + 1][j] += over / 2;
                            tower[start + 1][j + 1] += over / 2;
                            isOver = true;
                            tower[start][j] = 1.0f;
                            System.out.println("(" + start + ", " + j + ") : " + (over/2));
                        }
                    }
                }
                start++;
                System.out.println();
            }
        }

        System.out.println(Arrays.deepToString(tower).replaceAll("],", "\n"));
        
    }
}
