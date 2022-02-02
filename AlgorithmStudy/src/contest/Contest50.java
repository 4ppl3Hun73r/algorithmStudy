package contest;


import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/contest/weekly-contest-278/problems/all-divisions-with-the-highest-score-of-a-binary-array/
public class Contest50 {

    public List<Integer> maxScoreIndices(int[] nums) {
        int[] score = new int[nums.length + 1];

        int countOne = 0;
        for (int num : nums) {
            if (num == 1) countOne++;
        }
        int leftScore = 0;
        int rightScore = countOne;

        score[0] = leftScore + rightScore;
        int max = score[0];
        for (int i = 1; i < score.length; i++) {
            if (nums[i - 1] == 0) {
                leftScore++;
            } else {
                rightScore--;
            }
            score[i] = leftScore + rightScore;
            max = Math.max(max, score[i]);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < score.length; i++) {
            if (score[i] == max) {
                result.add(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Contest50 c = new Contest50();

    }
}
