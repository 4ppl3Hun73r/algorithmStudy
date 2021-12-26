package contest;

import java.util.*;

public class Contest23 {

    /*
    특정 케이스에서 실패 함
      https://leetcode.com/contest/weekly-contest-273/submissions/detail/607234227/
    대회중에는 hidden case라고 해서 당황함.
    그런데 케이스 알려 줬어도 디버깅 못 했을 듯

    다른 사람이 질문 올려서 확인해 봤는데
    https://leetcode.com/problems/intervals-between-identical-elements/discuss/1647521/5761-Pass%3A-Help-(Map-and-Formula)
    int로 계산해서 overflow 남

     */
    public long[] getDistances(int[] arr) {
        int len = arr.length;
        long[] result = new long[len];

        Map<Integer, List<Integer>> posMap = new HashMap<>();
        Map<Integer, List<Long>> subSumMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            if (!posMap.containsKey(val)) {
                posMap.put(val, new ArrayList<>());
                posMap.get(val).add(i);

                subSumMap.put(val, new ArrayList<>());
                subSumMap.get(val).add((long)i);
                continue;
            }
            posMap.get(val).add(i);
            List<Long> subSum = subSumMap.get(val);
            subSum.add(subSum.get(subSum.size() - 1) + i);
        }
        /*
            a   b   c   d
         a a-a b-a c-a d-a  -> () + -3 * a + (b + c + d)
         b b-a b-b c-b d-b  -> (-a) + 0b + (c + d)
         c c-a c-b c-c d-c  -> (-a -b) + -1 * c + (d)
         d d-a d-b d-c d-d  -> (-a -b -c) + 3 * d + ()

         pos 기준으로 left 는 빼고 right 는 더하기
         거기에 자기 자신은 왼쪽 카운트 - 오른쪽 카운트 * 자기 자신 값
         */

        for (Integer val : posMap.keySet()) {
            List<Integer> posList = posMap.get(val);
            List<Long> subSubList = subSumMap.get(val);
            int size = posList.size();
            for (int i = 0; i < posList.size(); i++) {
                int a = posList.get(i);
                long left = i;
                long right = size - i - 1;
                if (right < 0) {
                    right = 0;
                }
                result[a] += (left - right) * (long)a; // 여기 계산 할때 overflow 발생 ㅠㅠ
                result[a] += subSubList.get(size - 1) - subSubList.get(i);
                if (i > 0) {
                    result[a] -= subSubList.get(i - 1);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Contest23 c = new Contest23();

        /*for (int i = 0; i < 100000; i++) {
            System.out.print(10);
            System.out.print(",");
        }*/

        System.out.println(Arrays.toString(c.getDistances(new int[]{2,1,3,1,2,3,3})));
        System.out.println(Arrays.toString(c.getDistances(new int[]{10, 5, 10, 10})));
        System.out.println(Arrays.toString(c.getDistances(new int[]{10, 5, 10, 10, 10})));
    }
}

/*

 */
