package y2023.feb;

// https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/
public class Solution0213 {

    public int countOdds(int low, int high) {
        // 3,5,7
        // 8 9 10

        // 0 <= low <= high <= 10^9
        // high - low
        // (high - low) / 2
        // 1, 2, 3, 4, 5, 6, 7, 8, 9)
        // (10 - 1) /2 -> 5개
        // 1 - 10, 4 + 1
        // 1 - 9, 4 + 1
        // 0 - 10, 5

        return (high - low) / 2 + (low % 2 == 1 || high %2 == 1 ? 1 : 0);
    }
}
