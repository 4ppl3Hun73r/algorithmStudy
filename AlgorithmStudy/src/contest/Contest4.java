package contest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Contest4 {
    public int[][] validArrangement(int[][] pairs) {

        /*

        Input: pairs = [[5,1],[4,5],[11,9],[9,4]]
        Output: [[11,9],[9,4],[4,5],[5,1]]

        i, j 연결 시키기
         */

        int[][] result = new int[pairs.length][];

        Map<Integer, List<int[]>> startCntMap = new HashMap<>();
        Map<Integer, List<int[]>> endCntMap = new HashMap<>();

        for (int i = 0; i < pairs.length; i++) {
            int[] pair = pairs[i];
            if (!startCntMap.containsKey(pair[0])) {
                startCntMap.put(pair[0], new ArrayList<>());
            }
            startCntMap.get(pair[0]).add(pair);

            if (!endCntMap.containsKey(pair[1])) {
                endCntMap.put(pair[1], new ArrayList<>());
            }
            endCntMap.get(pair[1]).add(pair);
        }

        return result;
    }

    class Node {
        int s;
        int e;

        Node prev;
        Node next;
    }


    public static void main(String[] args) {
        Contest4 c = new Contest4();
    }
}
