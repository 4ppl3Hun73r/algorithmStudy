package contest;

import java.util.Arrays;

public class Contest41 {


    public int minimumCost(int[] cost) {

        /*
        6,5,7,9,2,2

        2, 2 => 9
        6, 5 => 7
        15


         */

        Arrays.sort(cost);

        int minimumCost = 0;
        for (int i = cost.length - 1; i >= 0; i -= 3) {
            minimumCost += cost[i];
            if (i > 0) {
                minimumCost += cost[i - 1];
            }
        }

        return minimumCost;
    }

    public static void main(String[] args) {
        Contest41 c = new Contest41();

    }
}
