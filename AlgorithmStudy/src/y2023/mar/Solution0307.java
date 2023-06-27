package y2023.mar;

// https://leetcode.com/problems/minimum-time-to-complete-trips/
public class Solution0307 {

    //[1,2,3] , 5

    public long minimumTime(int[] time, int totalTrips) {

        long left = 0;
        long right = Long.MAX_VALUE;

        while (left < right) {
            long tripTime = left + (right - left) / 2; // 시간 몇번을 갈수있는 구할려면 mid / time[i]

            long tripCount = 0;
            for (int t : time) {
                tripCount += tripTime / t;
                if (tripCount > totalTrips) {
                    break;
                }
            }

            if (tripCount < totalTrips) {
                left = tripTime + 1;
            } else {
                right = tripTime;
            }
        }

        return left;
    }
//    ORDER BY title0_.title_no DESC,
//            CASE
//    WHEN user6_.user_type = 'AUTHOR' THEN 1
//    WHEN user6_.user_type = 'COOPERATOR' THEN 3
//    WHEN user6_.user_type = 'OPERATOR' THEN 4
//    WHEN user6_.user_type = 'TRANSLATOR' THEN 5
//    WHEN user6_.user_type = 'WAT_PM' THEN 6
//    WHEN user6_.user_type = 'MARKETING' THEN 7
//    WHEN user6_.user_type = 'INSPECTION' THEN 8
//    ELSE 9
//    END ASC
}
