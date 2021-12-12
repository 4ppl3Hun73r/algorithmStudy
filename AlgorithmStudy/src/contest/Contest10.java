package contest;

public class Contest10 {
    public long subArrayRanges(int[] nums) {
        long sum = 0;
        // int len = numList.size();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int min = nums[i];
            int max = nums[i];
            for (int j = i + 1; j < len; j++) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                sum += max - min;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        Contest10 c = new Contest10();
        System.out.println(c.subArrayRanges(new int[]{4,-2,-3,4,1}));
    }
}
