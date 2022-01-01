package y2021.aug;


// https://leetcode.com/explore/featured/card/august-leetcoding-challenge-2021/615/week-3-august-15th-august-21st/3892/
public class Solution0817 {

    int[] nums;

    public Solution0817(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int left, int right) {
        int sum = 0;

        for (int i = left; i <= right; i++) {
            sum += nums[i];
        }

        return sum;

    }
}

// https://leetcode.com/problems/range-sum-query-mutable/
// 연결 문제를 풀다가 시간 초과로 실패
class NumArray {
    private int[] chunkSum;
    private int len;
    private int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
        double chunkSize = Math.sqrt(nums.length);
        len = (int) Math.ceil(nums.length / chunkSize);
        chunkSum = new int[len];
        for (int i = 0; i < nums.length; i++)
            chunkSum[i / len] += nums[i];
    }

    public int sumRange(int i, int j) {
        int sum = 0;
        int startBlock = i / len;
        int endBlock = j / len;
        if (startBlock == endBlock) {
            for (int k = i; k <= j; k++)
                sum += nums[k];
        } else {
            for (int k = i; k <= (startBlock + 1) * len - 1; k++)
                sum += nums[k];
            for (int k = startBlock + 1; k <= endBlock - 1; k++)
                sum += chunkSum[k];
            for (int k = endBlock * len; k <= j; k++)
                sum += nums[k];
        }
        return sum;
    }

    public void update(int i, int val) {
        int chunkIndex = i / len;
        chunkSum[chunkIndex] = chunkSum[chunkIndex] - nums[i] + val;
        nums[i] = val;
    }
}

/**
 *
 */


/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */