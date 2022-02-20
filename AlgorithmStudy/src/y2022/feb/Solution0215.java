package y2022.feb;

public class Solution0215 {
    public int singleNumber(int[] nums) {
        // bit manipulation
        /*
            every element appears twice except for one.
            Find that single one.
            위와 같은 전제 조건이 있어서 bit로 풀수 있음
         */
        int result = 0;
        for (int num : nums) {
            result ^= num; // 0 ^ 4 ^ 0 ^ 0
        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        Solution0215 s = new Solution0215();

        System.out.println(s.singleNumber(new int[]{4,1,2,1,2}));
        System.out.println(s.singleNumber(new int[]{1}));
        System.out.println(s.singleNumber(new int[]{2,2,1}));
    }
}
