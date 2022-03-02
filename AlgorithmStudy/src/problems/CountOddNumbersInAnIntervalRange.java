package problems;

// https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/
public class CountOddNumbersInAnIntervalRange {
    public int countOdds(int low, int high) {
        /*
         1 2 3 4 5 6 7 -> 4개
          7 - 1 : 6 / 2 -> 3
         2 3 4 5 6 7 8 -> 3개
          8 - 2 : 6 / 2 -> 3
         1 2 3 4 5 6   -> 3개
          6 - 1 : 5 / 2 -> 2
         2 3 4 5 6 7   -> 3개
          7 - 2 : 5 / 2 -> 2
         */
        boolean lowOdd = low % 2 == 1;
        boolean highOdd = high % 2 == 1;

        return (high - low) / 2 + (lowOdd || highOdd ? 1 : 0);


    }
}
