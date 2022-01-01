package y2021.dec;

// https://leetcode.com/problems/smallest-integer-divisible-by-k/
public class Solution1230 {
    public int smallestRepunitDivByK(int k) {
        // 1 <= k <= 10^5
        if(k%2 == 0 || k%5 == 0) {
            return -1;
        }
        /*
        n1 = n * 10 + 1
        n2 = (n * 10 + 1) * 10 + 1
        n3 = ((n * 10 + 1) * 10 + 1) * 10 + 1
        ...
        k > 1
        n1 % k = (n * 10 % k + 1)%k

        3
        1 -> 1
        11 -> 2
        21 -> 0

        5
        1 -> 1
        11 -> 1
        11 -> 11
        11 -> 11

        15
        25

        7
        1 ->
         */
        int n = 1;
        int result = 1;
        while (true) {
            int m = n % k;
            if (m == 0) {
                break;
            }
            // System.out.println(m);
            n = m * 10 + 1;
            result++;
            // if (result > 100) break;
        }
        return result; //
    }

    public int smallestRepunitDivByK2(int K) {
        // 순환소수 ->  321321321321321321321
        // set<> -> contains -> return -1
        // new boolean[K] -> > hashmap 처럼 사용
        //
        int remainder = 0;
        for (int length_N = 1; length_N <= K; length_N++) {
            remainder = (remainder * 10 + 1) % K;
            if (remainder == 0) {
                return length_N;
            }
        }
        return -1;
    }

    public int smallestRepunitDivByK3(int k) {
        int length = 1;
        // first check for numbers divisible by 2 or 5
        if(k % 2 == 0 || k % 5 == 0){
            return -1;
        }
        int rem = 1 % k;
        // repunit may be to large to have in memory, so get remainder each time instead of repunit

        // currently assumes number must be divisible by some repunit
        while(rem != 0){
            // 1
            // 11  3
            // 111
            // 1111
            rem = (rem * 10 + 1) % k;
            length++;
        }
        return length;
    }

    public static void main(String[] args) throws Exception {
        Solution1230 s = new Solution1230();

        for (int i = 1; i <= 100000; i+=2) {
            System.out.println(s.smallestRepunitDivByK(i));
            //System.out.println(i);
        }

        /*System.out.println(s.smallestRepunitDivByK(3));
        System.out.println(s.smallestRepunitDivByK(5));
        System.out.println(s.smallestRepunitDivByK(15));
        System.out.println(s.smallestRepunitDivByK(25));
        System.out.println(s.smallestRepunitDivByK(7));
        System.out.println(s.smallestRepunitDivByK(9));
        System.out.println(s.smallestRepunitDivByK(99999));*/
    }
}
