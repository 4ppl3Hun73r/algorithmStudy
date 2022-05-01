package y2022.apr;

import java.util.*;

// https://leetcode.com/problems/evaluate-division/
public class Solution0430 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        /*
        [0] : equations a / b => values[0]
        [1] : equations b / c => values[1]
        .....

        queries
          a, b = a / b
          ab bc = ab / bc


        a  b  2.0  == a = 6, b = 3
        b  c  3.0  == b = 3, c = 1
        ------
        a  c   = 6 / 1 => 6.0
        b  a   = 3 / 6 => 0.5
         */

        Map<String, Map<String, Double>> map = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String c = equation.get(0);
            String m = equation.get(1);

            if (!map.containsKey(c)) {
                map.put(c, new HashMap<>());
            }
            if (!map.containsKey(m)) {
                map.put(m, new HashMap<>());
            }

            map.get(c).put(m, values[i]);
            map.get(m).put(c, 1 / values[i]);
        }

        // System.out.println(map);
        double[] ans = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            String a = queries.get(i).get(0);
            String b = queries.get(i).get(1);

            ans[i] = getCalc(map, a, b, new HashSet<>());
        }

        return ans;
    }

    private double getCalc(Map<String, Map<String, Double>> map, String start, String end, Set<String> visited) {
        if (!map.containsKey(start)) {
            // 시작지점이 없으면 실패
            return -1.0;
        }

        if (map.get(start).containsKey(end)) {
            // a / b 가 있으면
            return map.get(start).get(end);
        }

        /*
            시작 -> 끝까지 찾아 가기
            중간에 값들은 곱해 나가면 됨
         */
        visited.add(start);
        for (Map.Entry<String, Double> neighbour : map.get(start).entrySet()) {
            // 방문한건 재 방문 못하게 막기
            if (!visited.contains(neighbour.getKey())) {
                double product = getCalc(map, neighbour.getKey(), end, visited);
                if (product != -1.0) {
                    return neighbour.getValue() * product;
                }
            }
        }

        return -1.0;
    }

    public static void main(String[] args) {
        Solution0430 s = new Solution0430();

        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("a", "b"));
        equations.add(Arrays.asList("b", "c"));
        double[] values = new double[] {2.0, 3.0};
        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("a", "c"));
        queries.add(Arrays.asList("c", "b"));
        queries.add(Arrays.asList("c", "a"));

        System.out.println(Arrays.toString(s.calcEquation(equations, values, queries)));
    }

}
