package y2022.nov;


import java.util.Stack;

// https://leetcode.com/problems/sum-of-subarray-minimums/
public class Solution1125 {
    public int sumSubarrayMins(int[] arr) {
        /*
        모든 서브배열에서의 min 값들을 더해라.

        DP, monotonic stack

        [1,2,3,4,5]
        [11,81,94,43,3]
      MS[11,3
        [-1,11,11,11,3]
               s.peek();
              *
          *   *   *
          * * *   *
          * * * * * *

          [3,1,2,4]

          [3,1,1,1]
             ^   ^
             1,2,4 -> 1
           3,1,2,4 -> 1

            [1,2] -> 1
          [3,1,2] -> 1

3 * 3 * 10^8
          dp[start][end] =
          dp[0][0] = 3
          dp[1][1] = 1
          dp[2][2] = 2
          dp[3][3] = 4
          dp[0][1] = Math.min(dp[0][0],arr[1])
          dp[0][2] = Math.min(dp[0][1], arr[2])

          dp[i][i] = arr[i];
          dp[i][i+1]


          [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4]
         */
        int mod = (int) (1e9) + 7;

        Stack<Integer> stack = new Stack<>();  // idx가 들어감
        long result = 0;

        for (int i = 0; i <= arr.length; i++) {

            while (!stack.isEmpty() && (i == arr.length || arr[stack.peek()] >= arr[i])) {
                // 자기보다 작은 애의 인덱스를 구할 수 있자나요.
                // 인덱스 0 ~ 인덱스 ~ 자기 까지 모든 subarray 는 -> result += arr[인덱스];
                int mid = stack.pop();
                int left = stack.empty() ? -1 : stack.peek();
                int right = i;

                long count = (mid - left) * (right - mid) % mod;

                result += (count * arr[mid]) % mod;
                result = result % mod;
            }
            stack.push(i);
        }

        return (int) (result);
    }

    public int sumSubarrayMinsSolution(int[] arr) {
        int MOD = 1000000007;

        Stack<Integer> stack = new Stack<>();
        long sumOfMinimums = 0;

        // building monotonically increasing stack
        for (int i = 0; i <= arr.length; i++) {

            // when i reaches the array length, it is an indication that
            // all the elements have been processed, and the remaining
            // elements in the stack should now be popped out.

            while (!stack.empty() && (i == arr.length || arr[stack.peek()] >= arr[i])) {

                // Notice the sign ">=", This ensures that no contribution
                // is counted twice. rightBoundary takes equal or smaller
                // elements into account while leftBoundary takes only the
                // strictly smaller elements into account

                int mid = stack.pop();
                int leftBoundary = stack.empty() ? -1 : stack.peek();
                int rightBoundary = i;

                // count of subarrays where mid is the minimum element
                long count = (mid - leftBoundary) * (rightBoundary - mid) % MOD;

                sumOfMinimums += (count * arr[mid]) % MOD;
                sumOfMinimums %= MOD;
            }
            stack.push(i);
        }

        return (int) (sumOfMinimums);
    }

    public int sumSubarrayMinsSolutionDP(int[] arr) {
        int MOD = 1000000007;

        Stack<Integer> stack = new Stack<>();

        // make a dp array of the same size as the input array `arr`
        int[] dp = new int[arr.length];

        // making a monotonic increasing stack
        for (int i = 0; i < arr.length; i++) {
            // pop the stack until it is empty or
            // the top of the stack is greater than or equal to
            // the current element
            while (!stack.empty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }

            // either the previousSmaller element exists
            if (stack.size() > 0) {
                int previousSmaller = stack.peek();
                dp[i] = dp[previousSmaller] + (i - previousSmaller) * arr[i];
            } else {
                // or it doesn't exist, in this case the current element
                // contributes with all subarrays ending at i
                dp[i] = (i + 1) * arr[i];
            }
            // push the current index
            stack.push(i);
        }

        // Add all elements of the dp to get the answer
        long sumOfMinimums = 0;
        for (int count : dp) {
            sumOfMinimums += count;
            sumOfMinimums %= MOD;
        }

        return (int) sumOfMinimums;
    }

    // 3 1 2 4
    // 3, 1, 1, 1 (3), (3,1),(3,1,2), (3,1,2,4)
    // x, 1, 1, 1       (1), (1,2), (1,2,4)
    // x, x, 2, 2             (2),  (2,4)
    // x, x, x, 4                   (4)



    // 3, 1, 2, 4, 3, 1, 2, 4
    // 0, 0, 1, 2, 2, 0, 1, 2

    public static void main(String[] args) throws Exception {
        Solution1125 s = new Solution1125();

        System.out.println(s.sumSubarrayMins(new int[]{3,1,2,4,3,1,2,4}));
    }
}
