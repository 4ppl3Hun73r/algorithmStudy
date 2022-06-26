package y2022.jun;

// https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
public class Solution0626 {
    public int maxScore(int[] cardPoints, int k) {
        /*
        양쪽에서 꺼낼수 있음
         */

        int sum = 0;
        for (int cardPoint : cardPoints) {
            sum += cardPoint;
        }

        int ans = 0;
        int window = 0;
        k = cardPoints.length - k;
        for (int i = 0; i < k; i++) {
            window += cardPoints[i];
        }

        ans = Math.max(ans, sum - window);
        for (int i = k; i < cardPoints.length; i++) {
            window -= cardPoints[i - k];
            window += cardPoints[i];

            ans = Math.max(ans, sum - window);
        }


        return ans;
    }
}
