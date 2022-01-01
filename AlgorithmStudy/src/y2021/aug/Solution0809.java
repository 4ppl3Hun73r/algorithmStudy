package y2021.aug;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

// https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/614/week-2-august-8th-august-14th/3874/
// https://leetcode.com/problems/rank-transform-of-a-matrix/discuss/909142/Python-Union-Find
public class Solution0809 {
    public int[][] matrixRankTransform(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] result = new int[row][col];

        // p, q 를 비교할떄
        // If p < q then rank(p) < rank(q)
        // If p == q then rank(p) == rank(q)
        // If p > q then rank(p) > rank(q)
        // rank는 가장 작은 것을 따라 감
        /*
        [[1,2]   => [[1,2]
         [3,4]]      [2,3]]

         [[20,-21,14]   => [[4,2,3]
          [-19,4,19]        [1,3,4]
          [22,-47,24]       [5,1,6]
          [-19,4,19]]       [1,3,4]]

          [4,0,0]
          [0,0,0]
          [0,0,0]
          [0,0,0]
         */

        return result;
    }


    // union find => 그래프 그룹화 알고리즘.
    static class UF {
        Integer[] parent;
        public UF(int n) {
            parent = new Integer[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        public int find(int x) {
            return parent[x] = parent[x] == x ? x : find(parent[x]);
        }

        public Pair<Integer, Integer> union(int x, int y) {
            int px = find(x);
            int py = find(y);
            parent[px] = py;

            // System.out.println(Arrays.deepToString(parent));

            return new Pair<>(px, py);
        }
    }

    static class Pair<K, V> {

        private final K element0;
        private final V element1;

        public Pair(K element0, V element1) {
            this.element0 = element0;
            this.element1 = element1;
        }

        public K getKey() {
            return element0;
        }

        public V getValue() {
            return element1;
        }
    }

    class Matrix {
        int val;
        int x;
        int y;

        public Matrix(int val, int x, int y) {
            this.val = val;
            this.x = x;
            this.y = y;
        }

        public Matrix() {
        }
    }

    public int[][] matrixRankTransform2(int[][] matrix) {

        int row = matrix.length;
        int colum = matrix[0].length;
        int[][] result = new int[row][colum];

        List<Matrix> matrixList = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < colum; j++) {
                Matrix m = new Matrix(matrix[i][j], i, j);
                matrixList.add(m);
            }
        }

        matrixList.sort((arg0, arg1) -> {
            int c1 = arg0.val;
            int c2 = arg1.val;
            return Integer.compare(c1, c2);
        });

        List<Matrix> sameValues = new ArrayList<>();
        Matrix prevVal = null;
        for (Matrix value : matrixList) {
            int rank = 1;
            int val = value.val;
            int columnIdx = value.y;
            int rowIdx = value.x;

            if (prevVal == null || prevVal.val != val) {
                sameValues = new ArrayList<>();
            }
            /* {{-39,-50,-3,44},
            {-39,46,13,-32},
            {47,-42,-3,-40},
            {-17,-22,-39,24}}*/

            for (int r = 0; r < row; r++) {
                if (r == rowIdx) {
                } else if (result[r][columnIdx] > 0 && matrix[r][columnIdx] == val) {
                    rank = result[r][columnIdx];
                    break;
                } else if (result[r][columnIdx] > 0 && rank <= result[r][columnIdx]) {
                    rank = result[r][columnIdx] + 1;
                }
            }
            for (int c = 0; c < colum; c++) {
                if (c == columnIdx) {
                } else if (result[rowIdx][c] > 0 && matrix[rowIdx][c] == val) {
                    rank = Math.max(result[rowIdx][c], rank);
                    break;
                } else if (result[rowIdx][c] > 0 && rank <= result[rowIdx][c]) {
                    rank = Math.max(result[rowIdx][c] + 1, rank);
                }
            }

            if (prevVal != null && prevVal.val == val) {
                result[prevVal.x][prevVal.y] = rank;
                if (sameValues.size() != 0) {
                    for (Matrix m : sameValues) {
                        if (result[m.x][m.y] < rank) {
                            result[m.x][m.y] = rank;
                        }
                    }
                }
                sameValues.add(value);
            }

            result[rowIdx][columnIdx] = rank;
            prevVal = value;

        }

        return result;
    }

    public int[][] matrixRankTransform3(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] rank = new int[n + m];
        Map<Integer, List<Pair<Integer, Integer>>> invMap = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // tree map 을 이용해서 정렬하면서 동일한 값에 대한 좌표를 정리한다.
                invMap.computeIfAbsent(matrix[i][j], l -> new ArrayList<>()).add(new Pair<>(i, j));
            }
        }

        /*
          [1, 2]
          [2, 3]
          [3, 2]
          TreeMap
          1 -> (0, 0)
          2 -> (0, 1), (1, 0), (2, 1)
          3 -> (1, 1), (2, 0)
         */

        for (int key : invMap.keySet()) {   // key => [1,2,3] => 정렬된 순서
            UF uf = new UF(n + m);
            // union find
            // 좌표를 그룹화
            // 1 -> 한 그룹
            // 2 -> 한 그룹
            // 3 -> 한 그룹
            int[] rank2 = rank.clone(); // rank 크기도 2 + 3, uf 2 + 3
            // matrix 2 * 3 => 2 + 3 ???? 머지???
            /*
              y0  y1
            x0[1, 2]
            x1[2, 3]
            x2[3, 2]
             */
            for (Pair<Integer, Integer> coord : invMap.get(key)) {
                // UF -> arr => n + m | 2, 3 =/ 2 * 3
                // UF -> index 0 is row[0], index 1 is row[1], index 2 is row[2]
                //    -> index 3 is col[0], index 4 is col[1]
                // index : [0, 1, 2, 3, 4]
                // value : [0, 1, 2, 3, 4]
                /*
                  TreeMap
                  1 -> (0, 0)
                  2 -> (0, 1), (1, 0), (2, 1)
                  3 -> (1, 1), (2, 0)
                 */
                // [3, 1, 2, 3, 4]
                // [3, 2, 2, 3, 4]
                // [3, 3, 2, 3, 4] uf arr <-

                /*
                 index: 0  1  2  3  4
                 array:[0, 1, 2, 3, 4]
                 의미 : [x0, x1, x2, y0, y1]

                 index 0, value 3 => 0 != 3 => index 3 =>
                 index 3, value 3 => 부모 -> 그룹의 주인 3이겠네...
                 [3, 1, 2, 3, 4]
                 uf.find(x) => 3
                 uf.find(y) => uf.find(y + x.len) => 그룹 주인 3이구나.
                 y0, y1, y2 => (0, 1, 2) + x.length // bbbbb
                 [x0, x1, x2, y0, y1]
                 */
                Pair<Integer, Integer> res = uf.union(coord.getKey(), coord.getValue() + n);
                // result -> x0, y0 ?? -> 그룹의 좌표..
                rank2[res.getValue()] = Math.max(rank2[res.getValue()], rank2[res.getKey()]);
                // 부모의 랭킹은 x0 y0 중에 큰거.
                // rank arr / rank2 arr / uf 값이, x0, y0 의 가장 작은 랭크 크기
                // [1, 1, 1, 0, 0]
            }
            for (Pair<Integer, Integer> coord : invMap.get(key)) {
                rank[coord.getKey()]
                        = rank[coord.getValue() + n]
                        = matrix[coord.getKey()][coord.getValue()]
                        = rank2[uf.find(coord.getKey())] + 1;
                // rank  : [1, 0, 1, 0, 0]
                // rank2 : [0, 0, 0, 0, 0]

                // (0, 1), (1, 0), (2, 1)
                // (1, 1), (2, 0)
                // rank  : [2, 3, 3, 3, 3]
                // rank2 : [1, 1, 1, 0, 0]
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        List<Pair<Integer, Integer>> test = new ArrayList<>();
        test.add(new Pair<>(0, 0));
        test.add(new Pair<>(0, 1));
        test.add(new Pair<>(1, 0));

        UF uf = new UF(5);
        for (Pair<Integer, Integer> t : test) {
            Pair<Integer, Integer> res = uf.union(t.getKey(), t.getValue() + 2);
            System.out.println(String.format("px: %d, py: %d", res.getKey(), res.getValue()));
        }

        for (Pair<Integer, Integer> t : test) {
            System.out.println(uf.find(t.getKey()));
        }

    }




}
