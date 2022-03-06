package y2022.mar;


// https://leetcode.com/problems/count-all-valid-pickup-and-delivery-options/
public class Solution0306 {
    int mod = 1000000007;
    long[][] cache;

    public int countOrders(int n) {
        /*
        n개를 배달하는데 가능한 모든 조합의 수
        1 -> (p1, d1)
        2 -> (p1, p2, d1, d2)
             (p1, p2, d2, d1)
             (p1, d1, p2, d2)
             (p2, p1, d1, d2)
             (p2, p1, d2, d1)
             (p2, d2, p1, d1)

             p1 -> 4 - 1
             p2 -> 4 - 1

             p1 -> 32 - 2
             p2 -> 32 - 2
             p3 -> 32 - 2

             p1 ->

        1 -> 1
        2 -> 6
        3 -> 90
        4 -> 2520
        5 -> 113400
        6 -> 7484400
        7 -> 681080400
        8 -> 729647433
        9 -> 636056472
        10 -> 850728840
        11 -> 518360668
        12 -> 67543367
        13 -> 951594128
        14 -> 702577871
        15 -> 621371750
        16 -> 200385844
        17 -> 416457700
        18 -> 368349166
        19 -> 949461892
        20 -> 580270580
         */

        cache = new long[n + 1][n + 1];
        return (int)allCombination(n, n);
    }

    private long allCombination(int unP, int unD) {
        if (unP == 0 && unD == 0) {
            // 모두 사용 했을떄
            return 1;
        }

        if (unP < 0 || unD < 0 || unD < unP) {
            // 오류 상황
            return 0;
        }

        if (cache[unP][unD] != 0) {
            return cache[unP][unD];
        }

        long ans = 0;
        ans += unP * allCombination(unP - 1, unD); // P를 뽑아쓸떄
        ans %= mod;

        ans += (unD - unP) * allCombination(unP, unD - 1); // D를 뽑았을
        ans %= mod;

        cache[unP][unD] = ans;

        return ans;
    }

    public static void main(String[] args) {
        Solution0306 s = new Solution0306();
        //System.out.println(s.countOrders(1));
        System.out.println(s.countOrders(2));
        System.out.println(s.countOrders(3));
        System.out.println(s.countOrders(4));
        System.out.println(s.countOrders(5));
        System.out.println(s.countOrders(6));
    }
}





















