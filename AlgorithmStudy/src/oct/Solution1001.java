package oct;

// https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/640/week-5-september-29th-september-30th/3993/
public class Solution1001 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        // k 개의 subset 으로 나눠질수 있으면 true 아니면 false
        // 단 모든 subset 은 동일한 sum 을 가져야함.

        // 방법1 => 모든 subset을 만들고 만드는 과정에서 sum이 같지 않으면 만들지 않기
        // worst case (subset을 만들수 없을때) 가 자주 나올 수 있음.

        // nums 를 모두 더하고 k로 나누면 sum(subset) 의 값이 나옴



        return true;
    }

}

/*

subset : [1 ~ 4] 까지의 길이
1 <= k <= nums.length <= 16



 */