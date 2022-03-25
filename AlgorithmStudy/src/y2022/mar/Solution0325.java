package y2022.mar;


import java.util.Arrays;
import java.util.Comparator;

/// https://leetcode.com/problems/two-city-scheduling/
public class Solution0325 {
    public int twoCitySchedCost(int[][] costs) {
        /*
        면접자 가 N명만큼 있다.
        각 면접자는 A 도시나 B 도시로 이동해서 면접을 볼 수 있다.
        costs는 i 번째 면접자가 A, B 로 이동할때의 비용이다.
        최소의 비용으로 모든 사람이 정확하게 2개로 분리될 수 있게 해야 한다.
         */
        /*
          비용 차이로 정렬을 해서, 비용차이가 큰 면접자 부터 도시에 배정 처리
          [10, 400][300, 10][10, 200][10, 100]
          A10 + A10 + B200 + B100 -> 제일 min 이지 않나?
          A10 + A10 + A10 + B100
         */
        int ans = 0;

        Comparator<int[]> comparator = (o1, o2) -> Math.abs(o2[0] - o2[1]) - Math.abs(o1[0] - o1[1]);
        Arrays.sort(costs, comparator);

        System.out.println(Arrays.deepToString(costs));

        int len = costs.length;
        int cityA = len / 2;
        int cityB = cityA;
        int i = 0;
        while (cityA != 0 && cityB != 0) {
            int[] cost = costs[i++];
            if (cost[0] < cost[1]) {
                cityA--;
                ans += cost[0];
            } else {
                cityB--;
                ans += cost[1];
            }
        }

        while (cityA != 0 && i < len) {
            ans += costs[i++][0];
        }
        while (cityB != 0 && i < len) {
            ans += costs[i++][1];
        }

        return ans;
    }

    public static void main(String[] args) throws Exception {
        Solution0325 s = new Solution0325();

        System.out.println(s.twoCitySchedCost(new int[][]{
                {259,770},{448,54},{926,667},{184,139},{840,118},{577,469}
        })); // 1859
    }
}
