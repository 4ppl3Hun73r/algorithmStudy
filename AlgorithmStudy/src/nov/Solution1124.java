package nov;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/interval-list-intersections/
public class Solution1124 {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        ArrayList<int[]> result = new ArrayList<>();
        /*
        Input:
        firstList = [[0,2],[5,10],[13,23],[24,25]]
        secondList = [[1,5],[8,12],[15,24],[25,26]]
        Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]

         A |------|       |---|    |---|
         B     |------|       |-----|
         ANS)  |--|           |    ||

         A     |------|
         B |------|
         ANS)  |--|

         A |------||-----|
         B     |------|

         A     |------|
         B |------|     |------|

         //  13ms
         //   3ms
         */

        int jIdx = 0;
        // A
        for (int i = 0; i < firstList.length; i++) {

            int[] sectionA = firstList[i];
            int minA = sectionA[0];
            int maxA = sectionA[1];

            // B
            for (int j = jIdx; j < secondList.length; j++) {
                int[] sectionB = secondList[i];
                int minB = sectionB[0];
                int maxB = sectionB[1];
                /*


                 minA   maxA
                A |----------------------|
                B     |------|   |---|
                     minB  maxB
                ANS   |--|       |---|
                    minB maxA

                        minA   maxA
                A         |------|
                B     |------|
                     minB    maxB
                ANS       |--|
                        minA maxB

                 */

                if (maxA < minB) {
                    /*
                    i |-----------| |---|
                    j               |----| |------|
                     */
                    jIdx = j;
                    break;
                }

                /*
                *    minA   maxA
                    A |------|
                    B     |------|
                         minB    maxB
                    ANS   |--|
                        minB maxA
                * */
                int[] resultSection = new int[2];
                if (maxB >= minA) {
                    resultSection[0] = minA;
                    resultSection[1] = maxB;
                } else {
                    resultSection[0] = minB;
                    resultSection[1] = maxA;
                }

                result.add(resultSection);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
    
    public int[][] intervalIntersection0(int[][] firstList, int[][] secondList) {
        ArrayList<int[]> result = new ArrayList<>();

        int startJ = 0;
        for (int i = 0; i < firstList.length; i++) {
            int[] interval1 = firstList[i];
            int start1 = interval1[0];
            int end1 = interval1[1];

            for (int j = startJ; j < secondList.length; j++) {
                /*
                [[0,5],[12,14],[15,18]]
                [[11,15],[18,19]]
                 */
                int[] interval2 = secondList[j];
                int start2 = interval2[0];
                int end2 = interval2[1];
                if (end1 < start2) {
                    /*
                    |-----------| |---|
                                 |----| |------|
                     */
                    startJ = j;
                    break;
                }

                if (start1 <= start2) {
                    int[] intersection = new int[2];
                    intersection[0] = start2;
                    intersection[1] = Math.min(end1, end2);
                    result.add(intersection);
                } else if (start1 <= end2) {
                    int[] intersection = new int[2];
                    intersection[0] = start1;
                    intersection[1] = Math.min(end1, end2);
                    result.add(intersection);
                }
                /*
                 A |------|
                 B     |------|

                 A     |------|
                 B |------|
                 */
            }
        }

        return result.toArray(new int[0][0]);
    }

    public int[][] a(int[][] A, int[][] B) {
        List<int[]> ans = new ArrayList();
        int i = 0, j = 0;

        // O(Max(N, M))
        while (i < A.length && j < B.length) {
            // Let's check if A[i] intersects B[j].
            // lo - the startpoint of the intersection
            // hi - the endpoint of the intersection
            int lo = Math.max(A[i][0], B[j][0]);
            int hi = Math.min(A[i][1], B[j][1]);
            if (lo <= hi)
                ans.add(new int[]{lo, hi});


                /*
                 A |------||-----|
                 B     |------|

                 A     |------|
                 B |------|     |------|
                 */

            // Remove the interval with the smallest endpoint
            if (A[i][1] < B[j][1])
                i++;
            else
                j++;
        }

        return ans.toArray(new int[ans.size()][]);

    }

    public static void main(String[] args) throws Exception {
        int index = 0;
        for (int i = 0; i < 1000; i++) {
            System.out.print("[");
            System.out.print(index++);
            System.out.print(",");
            System.out.print(index++);
            System.out.print("]");
            System.out.print(",");
        }
    }
}
