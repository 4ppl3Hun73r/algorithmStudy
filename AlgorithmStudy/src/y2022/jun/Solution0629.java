package y2022.jun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// https://leetcode.com/problems/queue-reconstruction-by-height/
public class Solution0629 {
    public int[][] reconstructQueue(int[][] people) {
        /*
        숫자가 작은게 먼저 인데
        앞에 front 값을 보고 몇명이 있어야 하면 그게 더 앞으로 와야함.
         */

        // 키가 작은 수로 정렬하는데 같은 키면 front 가 큰 걸로 기준으로 정렬
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                }
                // 같으면 일단 front
                return o1[0] - o2[0];
            }
        });

        // System.out.println(Arrays.deepToString(people));

        // 내가 사용 할 수 있는 index 정리
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < people.length; i++) {
            list.add(i);
        }

        int[][] res = new int[people.length][2];
        for (int i = 0; i < people.length; i++) {
            // index 를 꺼내옴
            // people 이  작은 키 & front 로 정렬되어 있어서 front 번째 index를 사용하면 됨
            int index = list.get(people[i][1]);
            res[index][0] = people[i][0];
            res[index][1] = people[i][1];
            // 사용한 index 제거
            // 0,1,2,3,4,5 -> 0,1,2,3,5
            // get(4) ->4 -> get(4) -> 5 가 나오는 식
            list.remove(people[i][1]);
        }

        return res;
    }

    public static void main(String[] args) throws Exception {
        Solution0629 s = new Solution0629();

        System.out.println(Arrays.deepToString(s.reconstructQueue(new int[][]{
                {7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}
        })));
    }
}
