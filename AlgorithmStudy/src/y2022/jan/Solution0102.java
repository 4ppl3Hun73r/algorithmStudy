package y2022.jan;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
public class Solution0102 {

    public int numPairsDivisibleBy60(int[] time) {

        // pair i < j, (time[i] + time[j]) % 60  == 0
        // n <= 60000
        int pairCnt = 0;
        Map<Integer, Set<Integer>> posMap = new HashMap<>();
        for (int i = 0; i < time.length; i++) {
            time[i] = time[i] % 60;
            if ( !posMap.containsKey(time[i]) ) {
                posMap.put(time[i], new HashSet<>());
            }
            posMap.get(time[i]).add(i);
        }


        for (int i = 0; i < time.length; i++) {
            int find = 60 - time[i];
            if (find == 60) find = 0;
            // 중복 pair 제거 해야 함.
            if (posMap.containsKey(find)) {
                posMap.get(time[i]).remove(i);
                pairCnt += posMap.get(find).size();
            }
        }

        return pairCnt;
    }

    public static void main(String[] args) {
        Solution0102 s = new Solution0102();

        //System.out.println(s.numPairsDivisibleBy60(new int []{30,20,150,100,40}));
        System.out.println(s.numPairsDivisibleBy60(new int []{60,60,60}));

        /*Random random = new Random();
        for (int i = 0; i < 60000; i++) {
            System.out.print(random.nextInt(499) + 1);
            System.out.print(",");
        }*/
    }
}
