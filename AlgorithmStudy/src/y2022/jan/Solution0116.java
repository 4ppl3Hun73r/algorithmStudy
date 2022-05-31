package y2022.jan;

import java.util.Random;

// https://leetcode.com/problems/maximize-distance-to-closest-person/
public class Solution0116 {
    public int maxDistToClosest(int[] seats) {



        boolean leftPersonIdx = false;
        int maxDist = 0;
        int dist = 0;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                if (!leftPersonIdx) {
                    maxDist = Math.max(maxDist, dist);
                } else {
                    maxDist = Math.max(maxDist, (dist + 1) / 2);
                }
                leftPersonIdx = true;
                dist = 0;
            } else {
                dist ++;
            }
        }

        if (seats[seats.length - 1] != 1) {
            maxDist = Math.max(maxDist, dist);
        }

        return maxDist;
    }

    public static void main(String[] args) {

        Random random = new Random();
        for (int i = 0; i < 20000; i++) {
            System.out.printf("%d,", random.nextInt(2));
        }


    }
}
