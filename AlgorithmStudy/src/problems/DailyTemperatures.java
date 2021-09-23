package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

// https://leetcode.com/problems/daily-temperatures/
public class DailyTemperatures {
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

    public static void main(String[] args) {
        DailyTemperatures d = new DailyTemperatures();
        System.out.println(Arrays.toString(d.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }
}

/*
answer[i] = i 번째 날 이후 더 따뜻한 온도를 얻기 위해 기다려야 하는 날
[73,74,75,71,69,72,76,73]
[1,1,4,2,1,1,0,0]
73도 1일
74도 1일
75도 4일
71도 2일
69도 1일
72도 1일
76도 0일
73도 0일

[73]
[76] 72

array? stack? mono stack? monotonic stack?
 */
