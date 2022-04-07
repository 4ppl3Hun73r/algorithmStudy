package y2022.apr;

// https://leetcode.com/problems/3sum-with-multiplicity/
public class Solution0406 {
    public int threeSumMulti(int[] arr, int target) {
        int mod = 1000000007;
        long[] cnt = new long[101];
        for (int num : arr) {
            cnt[num] ++;
        }

        long ans = 0;

        // i != j != k
        for (int i = 0; i < 101; i++) {
            if (cnt[i] != 0) {
                for (int j = i + 1; j < 101; j++) {
                    if (cnt[j] != 0) {
                        int k = target - i - j;
                        if (j < k && k < 101) {
                            ans += cnt[i] * cnt[j] * cnt[k];
                            ans = ans % mod;
                        }
                    }
                }
            }
        }

        // i == j != k
        for (int i = 0; i < 101; i++) {
            if (cnt[i] != 0) {
                int k = target - (i * 2);
                if (i < k && k < 101) {
                    ans += ((cnt[i] * (cnt[i] - 1)) / 2) * cnt[k];
                    ans = ans % mod;
                }
            }
        }

        // i != j == k
        for (int i = 0; i < 101; i++) {
            if (cnt[i] != 0 && target % 2 == i % 2) {
                int k = (target - i) / 2;
                if (i < k && k < 101) {
                    ans += cnt[i] * ((cnt[k] * (cnt[k] - 1)) / 2);
                    ans = ans % mod;
                }
            }
        }

        // i == j == k
        if (target % 3 == 0) {
            int k = target / 3;
            if (0 <= k && k < 101) {
                ans += (cnt[k] * (cnt[k] - 1) * (cnt[k] - 2)) / 6;
                ans = ans % mod;
            }
        }

        return (int)ans;


    }
}
