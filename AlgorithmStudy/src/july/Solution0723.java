package july;

public class Solution0723 {

    public int partitionDisjoint2(int[] nums) {
        int len = nums.length;
        int prevMax = nums[0];
        int candidateMax = nums[0];
        int count = 0;
        for (int i = 0; i < len; i++) {
            candidateMax = Math.max(candidateMax, nums[i]);
            if (prevMax > nums[i]) {
                prevMax = candidateMax;
                count = i;
            }
        }

        // O(N), O(1)
        //    [5, 0, 3, 8, 1, 9, 11 ]
        // 1. prevMax = 5, candidateMax = 5, count = 1
        // 2. prevMax = 5, candidateMax = 5, count = 2
        // 3. prevMax = 5, candidateMax = 5, count = 3  --- 기억
        // 4. prevMax = 5, candidateMax = 8, count = 3
        // 5. prevMax = 8, , count = 3
        return count + 1;
    }

    public int partitionDisjoint3(int[] nums) {

//    [5, 0, 3, 8, '1', 9, 11 ]
        for (int i = 0; i < nums.length; i++) {
            int lMax = Integer.MIN_VALUE;
            int rMin = Integer.MAX_VALUE;

            lMax = Math.max(lMax, nums[i]);

            for (int j = i + 1; j < nums.length; j++) {
                rMin = Math.min(rMin, nums[j]);
            }

            if (lMax <= rMin) {
                return i + 1;
            }
        }
        // O(1), O(N * N() => NLogn, ....max n2 => O(N2)

        return 0;
    }
    public int partitionDisjoint(int[] nums) {
        int result = 0;

        int len = nums.length;
        int max = nums[0];
        int min = nums[len - 1];
        int[] maxArr = new int[len];
        int[] minArr = new int[len];
        for (int i = 0; i < len; i++) {
            max = Math.max(max, nums[i]);
            maxArr[i] = max;
        }
        // [5,5,5,8,8]

        for (int i = len - 1; i >= 0; i--) {
            min = Math.min(min, nums[i]);
            minArr[i] = min;
        }
        // [0,0,3,6,6]

        for (int i = 0; i < len - 1; i++) {
            if (maxArr[i] <= minArr[i + 1]) { // max <= min
                // cursor 에 해당 부분.
                result = i;
                break;
            }
        }

        // O(N), O(2N) => O(N)
        //


        return result + 1;
    }


}


// [5,0,3,8,6]
// (max)->  |  <-(min)

// 5,, [1]0386



/*
while(true){ // ?

    while(){
    }

    while(){
    }
}
 */