package y2022.jul;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// https://leetcode.com/problems/matchsticks-to-square/
public class Solution0712 {
    boolean result = false;
    public boolean makesquare(int[] matchsticks) {
        // 성냥으로 정사각형을 만들 수 있으면 true / false
        /*

         1 <= matchsticks.length <= 15

         4a = sum(matchsticks)
         a값이 포함되어있거나 남은 애들로 만들 수 있어야함
         */
        long sum = 0;
        for (int matchstick : matchsticks) {
            sum += matchstick;
        }
        if ((sum % 4) != 0) {
            return false;
        }
        int line = (int) (sum / 4L);
        // cache -> bit
//      int cacheKey : 000000000000000
        //

        //System.out.println(line);

        List<Integer> matchList = Arrays.stream(matchsticks)
                .boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());


        int cacheKey = 0;

        //return dfs(matchsticks, line, 0, 0, cacheKey);
        return dfs2(matchList, new int[4], 0, line);
    }




    private boolean dfs2(List<Integer> matchsticks, int[] lines, int idx, int line) {
        if (idx == matchsticks.size()) {
            return lines[0] == line && lines[1] == line && lines[2] == line && lines[3] == line;
        }

        int len = matchsticks.get(idx);
        for (int i = 0; i < 4; i++) {
            if (lines[i] + len <= line) {
                lines[i] += len;

                if (dfs2(matchsticks, lines, idx + 1, line)) {
                    return true;
                }

                lines[i] -= len;
            }
        }

        return false;
    }

    private void dfs(int[] matchsticks, int line, int lineSum, int lineCnt, int cacheKey, int current) {
        if (lineCnt == 4) {
            result = cacheKey == 0;
            return;
        }

        //[7215807,6967211,5551998,6632092,2802439,821366,2465584,9415257,8663937,3976802,2850841,803069,2294462,8242205,9922998]

        for (int i = current; i < matchsticks.length; i++) {
            if(((1 << i) & cacheKey) == 1) {
                continue;
            }

            int sum = lineSum + matchsticks[i];

            if(sum == line) {
                dfs(matchsticks, line, 0, lineCnt + 1, cacheKey & (1 << i), i+1);
            } else {
                dfs(matchsticks, line, sum, lineCnt, cacheKey & (1<< i), i+1);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Solution0712 s = new Solution0712();

        System.out.println(s.makesquare(new int[]{5,5,5,5,4,4,4,4,3,3,3,3}));
    }
}
