package contest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Contest62 {
    public int minimumOperations(int[] nums) {

       /*
       nums[i - 2] == nums[i], where 2 <= i <= n - 1.
       nums[i - 1] != nums[i], where 1 <= i <= n - 1

       3,1,3,2,4,3
       ->
       3,1,3,1,3,1

       1,2,2,2,2
       ->
       1,2,1,2,1
       인접한건 다르고 퐁당 퐁당으로 만드는데 최소한으로 만들어야함
        */

        Map<Integer, Integer> evenIdxNumCntMap = new HashMap<>();
        Map<Integer, Integer> oddIdxNumCntMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                evenIdxNumCntMap.put(nums[i], evenIdxNumCntMap.getOrDefault(nums[i], 0) + 1);
            } else {
                oddIdxNumCntMap.put(nums[i], oddIdxNumCntMap.getOrDefault(nums[i], 0) + 1);
            }
        }

        int evenMaxNum = 0;
        int evenMaxNextNum = 0;
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(evenIdxNumCntMap.entrySet());
        list.sort(Map.Entry.comparingByValue());
        evenMaxNum = list.get(list.size() - 1).getKey();
        if (list.size() > 1) {
            evenMaxNextNum = list.get(list.size() - 2).getKey();
        }


        int oddMaxNum = 0;
        int oddMaxNextNum = 0;
        list = new ArrayList<>(oddIdxNumCntMap.entrySet());
        list.sort(Map.Entry.comparingByValue());
        if (list.size() > 0) {
            oddMaxNum = list.get(list.size() - 1).getKey();
        }
        if (list.size() > 1) {
            oddMaxNextNum = list.get(list.size() - 2).getKey();
        }

        int half = nums.length / 2;
        int evenCnt = half + (nums.length%2 == 0 ? 0 : 1);
        int oddCnt = half;

        //System.out.println(evenIdxNumCntMap);
        //System.out.println(oddIdxNumCntMap);
        int result = Integer.MAX_VALUE;
        if (evenMaxNum == oddMaxNum) {
            result = Math.min(result,
                    (evenCnt - evenIdxNumCntMap.getOrDefault(evenMaxNum, 0))
                            + (oddCnt - oddIdxNumCntMap.getOrDefault(oddMaxNextNum, 0))
            );
            result = Math.min(result,
                    (evenCnt - evenIdxNumCntMap.getOrDefault(evenMaxNextNum, 0))
                            + (oddCnt - oddIdxNumCntMap.getOrDefault(oddMaxNum, 0))
            );
        } else {
            result = (evenCnt - evenIdxNumCntMap.getOrDefault(evenMaxNum, 0))
                    + (oddCnt - oddIdxNumCntMap.getOrDefault(oddMaxNum, 0));
        }


        return result;
    }

    public static void main(String[] args) {
        Contest62 c = new Contest62();

        System.out.println(c.minimumOperations(new int[]{3,3,3,3,1,1,1,1,2,2,2,2}));
        System.out.println(c.minimumOperations(new int[]{3,3,3,3,1,1,1,1,2,2,2}));
        System.out.println(c.minimumOperations(new int[]{3}));
        System.out.println(c.minimumOperations(new int[]{3,3}));
        System.out.println(c.minimumOperations(new int[]{1,1,2,1,1}));

        /*
        1,2,3,1,2,3,1,2,3,1,2,3,1,2,3
        1,2,1,2,1,2,1,2,1,2,1,2,1,2,1

        1,1,2,1,1
        2,1,2,1,2

        1,2,3,1,2,3,1,2,3,1,2,3,1,2,3
        1,2,1,2,1,2,1,2,1,2,1,2,1,2,1

         */

    }
}
