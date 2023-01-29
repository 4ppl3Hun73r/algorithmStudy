package problems;

// https://leetcode.com/problems/rotate-function/
public class RotateFunction {
    public int maxRotateFunction(int[] nums) {

        int sum = 0;
        int f = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            f += i * nums[i];
            sum += nums[i];
        }


        int result = f;
        for (int i = len - 1; i > 0; i--) {
            f += sum - (len * nums[i]);
            result = Math.max(result, f);
        }

        return result;
    }

    /*
      F(0) 0 * a + 1 * b + 2 * c + 3 * d
      F(1) 0 * d + 1 * a + 2 * b + 3 * c
      F(2) 0 * c + 1 * d + 2 * a + 3 * b
      F(3) 0 * b + 1 * c + 2 * d + 3 * a


      F(1) - F(0) = a - 0a + 3b - 2b + 3c - 2c + 0d - 3d = a + b + c - 3d = (a + b + c + d) - 4d => all sum - 4d
      F(2) - F(1) = 0c - 3c + 1d - 0d + 2a - a + 3b - 2b = a + b + c - 3c = (a + b + c + d) - 4c => all sum - 4c


      F(1) - F(0) = (a + b + c + d) - 4d
      F(1) = (a + b + c + d) - 4d + F(0)

     */
}
