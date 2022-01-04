package y2022.jun;

// https://leetcode.com/problems/find-the-town-judge/
public class Solution0103 {
    public int findJudge(int n, int[][] trust) {
        /*
        판사가 있으면 판사의 index
        판사가 없으면 -1
        1. 판사는 아무도 믿지 않는다.
        2. 모두가 판사를 믿는다.
        3. 1, 2를 만족하는 사람은 한명이다. -> 판사가 한명이다.

        1 <= n <= 1000
        0 <= trust.length <= 10000
        trust unique
        trust [a, b] a != b
               -> a 는 b를 믿는다.
         */

        /*
          [1, 2, 3]
           t -> [[1,3],[2,3]]
           r : 3

          [1, 2, 3]
           t -> [[1,3],[2,3],[3,1]]
           r : -1

            1  2  3
           [0, 0, 2] -> 믿음이 == (n - 1)

           [2, 2, 2] O(n * m), O(m)

           [0, -1, 1] -> 못찾는거. => 요렇게?
         */
        int[] persons = new int[n + 1];
        for (int[] t : trust) {
            persons[t[0]] --;
            persons[t[1]] ++;
        }

        for (int i = 1; i <= n; i++) {
            if (persons[i] == (n - 1)) {
                return i;
            }
        }

        return -1;
    }
}
