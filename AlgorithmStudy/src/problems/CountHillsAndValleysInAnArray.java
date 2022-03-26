package problems;

public class CountHillsAndValleysInAnArray {
    public int countHillValley(int[] nums) {
        /*
         언덕과 계곡을 찾기
                       6  <-hill
                           5
     hill->  4
         2
                 1 1 <-- valley


        no hill, no valley
         6  6
              5  5
                     4
                        1
         */

        int before = nums[0];
        Boolean upDown = null; // up == true, down == false
        int ans = 0;
        for (int num : nums) {
            if (before < num) {
                // 올라가요.
                if (upDown != null && upDown == false ) {
                    ans++;
                }
                upDown = true;
            } else if (before > num) {
                // 내려가요.
                if (upDown != null && upDown == true ) {
                    ans++;
                }
                upDown = false;
            } else {
                // 상태 변화 없음
            }
            before = num;
        }


        return ans;


    }
}
