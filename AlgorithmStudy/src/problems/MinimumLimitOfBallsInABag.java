package problems;

public class MinimumLimitOfBallsInABag {
    public int minimumSize(int[] nums, int maxOperations) {
        /*
        operations 한번당 nums[i]를 한번 쪼갤 수 있다.
        max oper 만큼 진행 했을떄 max(nums[i]) 가 가장 작을 수 있게 해야 한다.


        N 을 반을 만드려면 1번의 oper이 필요함  -> 8 -> 4, 4
        N 을 1/3로 만드러면 2번의 oper가 필요  -> 9 -> 3, 6 -> 3, 3, 3
        N 을 1/4로 만드려면 4번의 oper가 필요 -> 8 -> 4, 4 -> 2, 2, 4 -> 2, 2, 2, 2

         */

        int left = 1;
        int right = 1000000000;

        while (left < right) {
            int mid = left + (right - left) / 2;
            //System.out.println(mid);

            int oper = 0;
            for (int i = 0; i < nums.length; i++) {
                oper += (nums[i] - 1) / mid;
            }
            //System.out.println(oper);

            if (oper > maxOperations) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
