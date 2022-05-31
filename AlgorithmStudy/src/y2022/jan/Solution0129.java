package y2022.jan;

// https://leetcode.com/problems/largest-rectangle-in-histogram/
public class Solution0129 {
    /*
    실패... https://leetcode.com/problems/largest-rectangle-in-histogram/discuss/28902/5ms-O(n)-Java-solution-explained-(beats-96)
    를 보고 해결 처리
     */
    public int largestRectangleAreaFail(int[] heights) {
        /*
        높이가 들어오면, 가장 큰 사각형을 구한다.
        5, 5, 6, -1, 3, -1
        int[] nextMinimumHeight = new int[heights.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() >= heights[i]) {
                stack.pop();
            }
            nextMinimumHeight[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(heights[i]);
        }

        int[] prevMinimumHeight = new int[heights.length];
        stack.clear();
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && stack.peek() >= heights[i]) {
                stack.pop();
            }
            prevMinimumHeight[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(heights[i]);
        }

        System.out.println(Arrays.toString(heights));
        System.out.println(Arrays.toString(nextMinimumHeight));
        System.out.println(Arrays.toString(prevMinimumHeight));
        */

        return 0;

    }

    public static int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        int[] lessFromLeft = new int[heights.length]; // 현재 위치에서 왼쪽기준으로 자기보다 적은 index의 위치
        int[] lessFromRight = new int[heights.length]; // 현재 위치에서 오른쪽 기준으로 자기보다 적은 Index 의 위치
        lessFromRight[heights.length - 1] = heights.length;
        lessFromLeft[0] = -1;

        for (int i = 1; i < heights.length; i++) {
            int p = i - 1;

            // 앞에 계산 된걸 가지고 빠르게 index 의 위치를 구할 수 있음
            while (p >= 0 && heights[p] >= heights[i]) {
                p = lessFromLeft[p];
            }
            lessFromLeft[i] = p;
        }

        // 위와 동일
        for (int i = heights.length - 2; i >= 0; i--) {
            int p = i + 1;

            while (p < heights.length && heights[p] >= heights[i]) {
                p = lessFromRight[p];
            }
            lessFromRight[i] = p;
        }

        /*
          0    1  2  3  4  5
    h    [2,   1, 5, 6, 2, 3]
    l    [-1, -1, 1, 2, 1, 4]
    r    [1,   6, 4, 4, 6, 6]
         */
        /*System.out.println(Arrays.toString(height));
        System.out.println(Arrays.toString(lessFromLeft));
        System.out.println(Arrays.toString(lessFromRight));*/

        // 미리 구한 좌우 높이의 위치를 가지고 크기를 구한다.
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            maxArea = Math.max(maxArea, heights[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
        }

        return maxArea;
    }

    public static void main(String[] args) {
        Solution0129 s = new Solution0129();

        System.out.println(s.largestRectangleArea(new int[] {2,1,5,6,2,3}));

    }
}
