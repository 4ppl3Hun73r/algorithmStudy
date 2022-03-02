package problems;

// https://leetcode.com/problems/find-nearest-point-that-has-the-same-x-or-y-coordinate/
public class FindNearestPointThatHasTheSameXOrYCoordinate {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int ans = -1;

        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            if (point[0] == x || point[1] == y) {
                int distance = Math.abs(x - point[0]) + Math.abs(y - point[1]);
                if (distance < minDistance) {
                    ans = i;
                    minDistance = distance;
                }
            }
        }

        return ans;

    }
}
