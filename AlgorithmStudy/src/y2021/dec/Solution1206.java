package y2021.dec;

// https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/
public class Solution1206 {
    public int minCostToMoveChips(int[] position) {
        int even = 0;
        int odd = 0;
        for (int i = 0; i < position.length; i++) {
            if (position[i] % 2 == 0) {
                even++;
            } else {
                odd ++;
            }
        }
        return Math.min(even, odd);

        /*
          0 1 2 3
              ^ ^
          0 1 2 3 4
              ^ ^ ^
         */
    }
}
