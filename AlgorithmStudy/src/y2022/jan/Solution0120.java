package y2022.jan;

// https://leetcode.com/problems/koko-eating-bananas/
public class Solution0120 {
    public int minEatingSpeed(int[] piles, int h) {
        /*
        [3,6,7,11], h = 8, k = 4
         k = 3, 1/2/3/4
         k = 5,
        [30,11,23,4,20], h = 5, k = 30
        [30,11,23,4,20], h = 6, k = 23

        Binary Search
        1 <= piles.length <= 10000
        piles.length <= h <= 1000000000
        1 <= piles[i] <= 1000000000
         */
        int min = 1;
        int max = 1; //???
        for (int pile : piles) {
            max = Math.max(pile, max); //
        }
        while (min < max) {
            int mid = min + (max - min) / 2;

            // 검증
            int tempH = 0;
            // N * logm => N + N * logm
            // 
            for (int pile : piles) {
                tempH += (pile / mid);
                if (pile % mid != 0) {
                    tempH ++;
                }
            }

            System.out.printf("min: %d, k: %d, max: %d, tempH: %d\n", min, mid, max, tempH);

            if (h < tempH) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }

        return max;
    }

    public static void main(String[] args) throws Exception {
        Solution0120 s = new Solution0120();

        System.out.println(s.minEatingSpeed(new int[]{3,6,7,11}, 8)); // 4
        System.out.println(s.minEatingSpeed(new int[]{30,11,23,4,20}, 5)); // 30
        System.out.println(s.minEatingSpeed(new int[]{30,11,23,4,20}, 6)); // 23

        System.out.println(s.minEatingSpeed(new int[]{4,4,4}, 12)); // 23

        System.out.println(s.minEatingSpeed(new int[]{1000000000,1000000000}, 3)); // 23

        /*Random random = new Random();

        for (int i = 0; i < 10000; i++) {
            System.out.printf("%d,", random.nextInt(1000000000) + 1);
        }*/
    }
}
