package y2022.aug;

import java.util.*;

// https://leetcode.com/problems/binary-trees-with-factors/
public class Solution0809 {

    long mod = 1000000007;
    Map<Integer, Long> memo = new HashMap<>();

    public int numFactoredBinaryTrees(int[] arr) {
        /*
        부모 == 자식의 곱

        [2, 4] => [2], [4], [4, 2, 2]
        [2, 4, 5, 10] => [2], [4], [5], [10], [4, 2, 2], [10, 2, 5], [10, 5, 2]

        [2] -> {}, {}, {}, {}, {}
        [4] -> {2, 2}
        [8] -> {2, 4}, {4, 2}    , {{2, 2}, 2}, {{2, 2}, 2}
         */
        Arrays.sort(arr);
        Set<Long> set = new HashSet<>();
        Map<Integer, List<int[]>> tree = new HashMap<>();
        for (int i : arr) {
            set.add((long)i);
                tree.put(i, new ArrayList<>());
            }
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    long mul = (long)arr[i] * (long)arr[j];
                    if (set.contains(mul)) {
                        tree.get((int)mul).add(new int[]{arr[i], arr[j]});
                    }
                }
            }
        System.out.println(tree);

        long ans = 0L;
        for (int i : arr) {
            ans = (ans + dp(i, tree)) % mod;
        }

        System.out.println(memo);

        return (int)(ans % mod);

    }

    private long dp(int value, Map<Integer, List<int[]>> tree) {
        if (memo.containsKey(value)) {
            return memo.get(value);
        }
        long count = 1L;

        List<int[]> list = tree.get(value);
        for (int[] mul : list) {

            count = (dp(mul[0], tree) * dp(mul[1], tree) + count) % mod;
        }

        count = count % mod;
        memo.put(value, count);
        return count;
    }

    public static void main(String[] args) throws Exception {
        Solution0809 s = new Solution0809();

        System.out.println(s.numFactoredBinaryTrees(new int[]{2,4,8}));
    }
}
