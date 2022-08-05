package y2022.aug;

import model.GridCodec;

import java.util.Comparator;
import java.util.PriorityQueue;

// https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
public class Solution0802 {
    public int kthSmallest(int[][] matrix, int k) {
        /*
        n*n 크기기의 matrix에서
         k 번째 작은 값을 가져반환하기
         matrix는 정렬되어 있음

         [1,  5, 9],
         [10,11,13],
         [12,13,15]

         // 8 번째를 찾는다 ->

         You must find a solution with a memory complexity better than O(n^2).

         All the rows and columns of matrix are guaranteed to be sorted in non-decreasing order.

         Follow UP
         Could you solve the problem with a constant memory (i.e., O(1) memory complexity)?
         Could you solve the problem in O(n) time complexity?

         PQ?, Binary Search?

         [1, 5, 14], -> 2 -> 3  -> 3
         [10,11,15], -> 2 -> 2  -> 3
         [12,13,16]  -> 1 -> 2  -> 2

         [1, 5, 10, 11, 12, 13, 14, 15, 16] -> (1 + 16) / 2 -> 8

         count : 2,
         2 < 8
         8 + 16 / 2 -> 12

         count : 5
         5 < 8
         (12 + 16) / 2 -> 14
         7 < 8

         14 + 16 / 2 -> 15
         8 == 8 -> 15

         [x, x, 12, 13, x,x,x, 15] ->

         -> 8

         */
// [1,2],
// [1,3]
        //2
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                // 1, 1  <- 3
                if (pq.size() == k && pq.peek() > anInt) {
                    pq.poll();
                    pq.add(anInt);
                } else if (pq.size() != k){
                    pq.add(anInt);
                }
            }
        }

        return pq.poll();
    }

    // ????
    public int kthSmallest2(int[][] matrix, int k) {

        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n - 1][n - 1];

        while (low < high) {
            int mid = (high - low) / 2 + low;
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                //  (-(insertion point) - 1)
                int c = binarySearch(matrix[i], mid);
                cnt += c;
                /*if (c >= 0) {
                    cnt += c + 1;
                } else {
                    cnt += (-c) - 1;
                }*/
            }
            System.out.println(mid);
            System.out.println(cnt);
            if (cnt < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    private int binarySearch(int[] sorted, int target) {
        int n = sorted.length;

        int start = 0;
        int end = n - 1;
        if (sorted[end] < target) {
            return end + 1;
        }
        if (sorted[start] > target) {
            return 0;
        }

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (sorted[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        if (sorted[start] == target) {
            return start + 1;
        }

        if (sorted[start] > target) {
            return start;
        }

        return end;
    }

    public static void main(String[] args) throws Exception {
        Solution0802 s = new Solution0802();

        GridCodec g = new GridCodec();

        System.out.println(s.kthSmallest2(g.getIntGrid("[[1,5,9],[10,11,13],[12,13,15]]"), 8));
    }
}
