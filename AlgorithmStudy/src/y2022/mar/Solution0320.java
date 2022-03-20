package y2022.mar;

// https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/
public class Solution0320 {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        /*
        tops 나 bottoms 를 같은 수를 가진 배열로 만들어야 한다.
        2 <= tops.length <= 2 * 104
        1 <= tops[i], bottoms[i] <= 6

        같은 index 에서만 swap 할 수 있다.

        최소한의 swap으로 만들기 and 만들 수 없으면 -1 반환
         */

        int minSwap = Integer.MAX_VALUE;
        int len = tops.length;
        for (int i = 1; i <= 6; i++) {
            int top = 0;
            int bottom = 0;
            boolean done = true;
            for (int j = 0; j < len; j++) {
                if (tops[j] != i && bottoms[j] != i) {
                    done = false;
                    break;
                }
                if (tops[j] == i && bottoms[j] == i) {
                    continue;
                }
                if (tops[j] == i) {
                    top ++;
                }
                if (bottoms[j] == i) {
                    bottom ++;
                }
            }
            if (done) {
                minSwap = Math.min(minSwap, Math.min(top, bottom));
            }
        }

        return minSwap == Integer.MAX_VALUE ? -1 : minSwap;
    }
}
