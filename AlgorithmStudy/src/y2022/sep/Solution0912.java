package y2022.sep;

import java.util.Arrays;

// https://leetcode.com/problems/bag-of-tokens/
public class Solution0912 {
    public int bagOfTokensScore(int[] tokens, int power) {
        /*
        token 을 올리는데 사용하면 power - tokens[i], 점수 +1
        token 을 내리는데 사용하면 power + tokens[i], 점수 -1

        최대 점수는?
         */

        Arrays.sort(tokens);

        int left = 0;
        int right = tokens.length - 1;
        int score = 0;
        while (left <= right) {
            // face down 은 score 가 0 이상일 때 할 수 있음
            if (power >= tokens[left]) {
                score++;
                power -= tokens[left];
                left++;
                continue;
            }
            if (tokens[right] + power >= tokens[left]) {
                if (score == 0) {
                    break;
                }
                if (left == right) {
                    right--;
                    continue;
                }
                score--;
                power += tokens[right];
                right--;
                continue;
            }
            break;
        }

        return score;
    }

    public static void main(String[] args) {
        Solution0912 s = new Solution0912();

        //System.out.println(s.bagOfTokensScore(new int[]{100,200,300,400}, 200));

        System.out.println(s.bagOfTokensScore(new int[]{71,55,82}, 54));
    }
}
