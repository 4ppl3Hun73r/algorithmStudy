package nov;

// https://leetcode.com/problems/daily-temperatures/
public class Solution1113 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];

        for (int i = temperatures.length - 1; i >= 0; i--) {
            int temperature = temperatures[i];
            int ans = 0;
            int j = i + 1;
            for (; j < temperatures.length; j++) {
                ans ++;
                if (temperatures[j] > temperature) {
                    break;
                }
                if(temperature < temperatures[answer[j] + j]){
                    ans = answer[j] + j - i;
                    break;
                }
            }
            if (j == temperatures.length) ans = 0;
            answer[i] = ans;
        }

        return answer;
    }
}
