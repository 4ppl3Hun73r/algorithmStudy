package y2022.oct;

// https://leetcode.com/problems/minimum-time-to-make-rope-colorful/
public class Solution1003 {
    public int minCost(String colors, int[] neededTime) {
       /*
       같은 색이 연속으로 나오면 안된다.

       colors => 알파벳 소문자

       neededTime 은 제거하는데 걸리는 시간
        */

       int minCost = 0;

       int len = colors.length();

        for (int i = 0; i < len; i++) {
            char color = colors.charAt(i);

            int j = i + 1;
            int total = neededTime[i];
            int max = neededTime[i];
            boolean needFind = false;
            for (; j < len; j++) {
                char nextColor = colors.charAt(j);
                if (color != nextColor) {
                    j--;
                    break;
                }
                needFind = true;
                total += neededTime[j];
                max = Math.max(max, neededTime[j]);
            }

            if ( needFind ) {
                minCost += (total - max);
                i = j;
            }

        }

       return minCost;
    }

    public static void main(String[] args) {
        Solution1003 s = new Solution1003();

        System.out.println(s.minCost("cddcdcae", new int[]{4,8,8,4,4,5,4,2}));
    }
}
