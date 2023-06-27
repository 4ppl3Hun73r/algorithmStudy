package y2023.mar;

import java.util.Arrays;

// https://leetcode.com/problems/reducing-dishes/
public class Solution0329 {
    public int maxSatisfaction(int[] satisfaction) {
        /*

        최대 만족을 위해서 - 이지만 제공해야 할 필요가 있음
        [ a, b, c, ... z] 일때

        [ a + 2 * b + 3 * c + ... n * z]       -> 답일 지도.. (가)
        [         b + 2 * c + ... (n - 1) * z] -> 답일 지도.. (나)
        [                 c + ... (n - 2) * z] -> 답일 지도.. (다)

        (가) - (나) => a + b + c + d + ... z
        (나) - (다) => b + c + d + ... z
        ...

        (나) = (다) + (b + c + d + ... z)

         */
        Arrays.sort(satisfaction);

        int ans = 0;
        int sum = 0;
        for (int i = satisfaction.length - 1; i >= 0; i--) {
            if (sum + satisfaction[i] <= 0) {
                // 음수로 내려가면 더이상 계산할 필요가 없음
                break;
            }
            sum += satisfaction[i]; // 한 접시만 내보냄, 다음에 2접시가 됨
            ans += sum; // 계속 누적이 되야함.
        }

        return ans;


    }
}
