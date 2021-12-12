package contest;

import java.util.HashMap;
import java.util.Map;

public class Contest12 {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {

        int start = startPos - k;
        int end = startPos;

        if (start < 0) {
            end = startPos - start;
            start = 0;
        }

        int endPos = 0;
        Map<Integer, Integer> fruitsMap = new HashMap<>();
        for (int[] fruit : fruits) {
            fruitsMap.put(fruit[0], fruit[1]);
            endPos = Math.max(endPos, fruit[0]);
        }

        int fruitCnt = 0;
        for(int i = start; i < end; i++) {
            if (fruitsMap.containsKey(i)) {
                fruitCnt += fruitsMap.get(i);
            }
        }
        int result = fruitCnt;
        while(end <= endPos) {
            if (fruitsMap.containsKey(start)) {
                fruitCnt -= fruitsMap.get(start);
            }
            start++;

            end++;
            if (fruitsMap.containsKey(end)) {
                fruitCnt += fruitsMap.get(end);
            }
            System.out.println(fruitCnt);
            result = Math.max(result, fruitCnt);
        }

        return result;
    }

    public static void main(String[] args) {
        Contest12 c = new Contest12();
        System.out.println(c.maxTotalFruits(new int[][]{
                {2, 8}, {6, 3}, {8, 6}
        }, 5, 4));
    }
}
