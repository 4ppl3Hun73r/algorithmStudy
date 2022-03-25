package y2022.mar;

import java.util.Arrays;

// https://leetcode.com/problems/boats-to-save-people/
public class Solution0324 {

    public int numRescueBoats(int[] people, int limit) {
        /*
          사람을 구해야 하는데 people => 몸무게
          배에 limit 무게가 있음
          배는 무한대로 보낼 수 있음 (최대 2명 씩)

          태울 사람을 골라야 하는데
          limit에 맞춰서 골라야 되니까. sort 하면 limit 에 맞춰서 사람을 꺼내기가 쉽다.
          Sort Why??
          Double Point
          Greedy
         */
        int ans = 0;

        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        while (left <= right) {
            ans++; // loop 한번당 배를 한대씩 보내는데
            //3,2,2,1 -> 1,2,2,3 -> (3), (1,2) (2)
            if (people[left] + people[right] <= limit) {
                // 2명을 태울수 있으면 2명을 태우고
                left++;
                right--;
            } else {
                // greedy 니까 큰 무게부터 줄이고
                right--;
            }
        }

        return ans;
    }
}
