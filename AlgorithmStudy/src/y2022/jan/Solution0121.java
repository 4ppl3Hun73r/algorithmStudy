package y2022.jan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/gas-station/
public class Solution0121 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        /*
        gas = [1,2,3,4,5], cost = [3,4,5,1,2], 3
        gas = [2,3,4], cost = [3,4,3], -1
        답은 유일함이 보장됨
         */
        int len = gas.length;

        List<Pair> pos = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            gas[i] -= cost[i];
            if (gas[i] >= 0) {
                pos.add(new Pair(gas[i], i));
            }
        }
        if (pos.size() == 0) {
            return -1;
        }
        pos.sort((a, b) -> b.val - a.val);
        System.out.println(pos);
        System.out.println(Arrays.toString(gas));

        for (Pair p : pos) {
            int idx = p.pos;
            int tempCost = 0;
            boolean check = true;
            for (int i = 0; i < len; i++, idx++) {
                tempCost += gas[idx%len];
                if (tempCost < 0) {
                    check = false;
                    break;
                }
            }
            if (check) {
                return p.pos;
            }
        }
        return -1;
    }

    class Pair {
        int pos;
        int val;

        public Pair(int val, int pos) {
            this.val = val;
            this.pos = pos;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "pos=" + pos +
                    ", val=" + val +
                    '}';
        }
    }

    public int canCompleteCircuitSolution(int[] gas, int[] cost) {
        int availableGas = 0;
        int totalGas = 0;
        int index = 0;
        for (int i = 0; i < gas.length; i++) {
            availableGas += gas[i] - cost[i];
            totalGas += gas[i] - cost[i];
            if (availableGas < 0) {
                availableGas = 0;
                index = i + 1;
            }
            // - - - + +
            //   - -
            // a ----> c 음수로 내려가면
            //   b --> c 이것도 의미가 없다.
            //         c
            /*
            a b c d e f g
            a + b >= 0
                b + c >= 0
            a + b + c < 0
            1 + 1 - 3
             */
            /*
            답을 i+1
            gas[i+1]-cost[i+1] >= 0,
            gas[i+1]-cost[i+1] + gas[i+2]-cost[i+2]>=0,
            gas[i+1]-cost[i+1]+gas[i+2]-cost[i+2]+...+gas[n-1]-cost[n-1]>=0,
            ...
            0<=j<=i
            gas[i+1]-cost[i+1] +...+gas[n-1]-cost[n-1] + gas[0]-cost[0]+gas[1]-cost[1]+...+gas[j]-cost[j]>=0,
            ...

             */
        }
        if (totalGas < 0) {
            return -1;
        }
        return index;
    }

    public static void main(String[] args) throws Exception {
        Solution0121 s = new Solution0121();

        System.out.println(s.canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2})); // 3
        System.out.println(s.canCompleteCircuit(new int[]{2,3,4}, new int[]{3,4,3})); // 3
    }
}
