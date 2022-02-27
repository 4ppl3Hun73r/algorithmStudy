package contest;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Contest67 {
    public List<Long> maximumEvenSplit(long finalSum) {

        List<Long> res = new ArrayList<>();

        if (finalSum%2 == 1) {
            return res; // 음수는 할수 없다.
        }

        long sum = 0;
        for(long i = 2; i <= finalSum && sum < finalSum; i += 2){
            res.add(i);
            sum+=i;
        }

        res.remove(sum-finalSum);

        return res;

    }

    public List<Long> maximumEvenSplitFail(long finalSum) {

        /*
        finalSum 을 만들수 있는 짝수들의 집합
         */
        List<Long> res = new ArrayList<>();

        if (finalSum%2 == 1) {
            return res; // 음수는 할수 없다.
        }

        /*

        2 + 2*x + 2*y + 2*z ... = finalSum
        2, 4, 6, 8, 10, 12, 14
        2
        4 = 2 * 2
        6 = 2 * 3
        8 = 2 * 4 == 2 + 6
        10 = 2 * 5 == 4 + 6

        6 -> 1 + 2 + 3
        28 -> 2 * 14 -> 2, 6, 8, 12 -> 1 3 4 6 -> 14
                                    -> 1 2 3 4 4
                                    ->
        [2,4,6,8,10,12,14,16,18...]
        [1,1,2,

        1 1 -> ? 4
        2 2 -> 8
        1 3 ->
        3 3 -> 12
        7 + 7
        3 + 4 + 7
        1 + 2 + 4 + 7 -> 2 + 4 + 8 + 14
         */
        long n = finalSum / 2;
        // n 을 만들 수 있는 1 ~ n 까지의 합?
        Set<Long> set = new TreeSet<>();
        split(set, n);

        System.out.println(set);
        long sum = 0;
        long sum2 = 0;
        for (Long num : set) {
            res.add(num * 2);
            sum += num;
            sum2 += num * 2;
        }
        System.out.println(sum);
        System.out.println(sum2);

        return res;
    }

    private boolean split(Set<Long> set, long n) {
        if (set.contains(n)) {
            return true;
        }
        if (n == 1 || n == 2) {
            set.add(n);
            return false;
        }
        long a = n / 2;
        long b = n - a;
        if (a == b) {
            if (split(set, a)) {
                set.add(n);
            } else {
                set.add(a);
            }
        } else {
            if (split(set, a)) {
                set.add(a);
            }
            if (split(set, b)) {
                set.add(b);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Contest67 c = new Contest67();

        System.out.println(c.maximumEvenSplit(12));
        System.out.println(c.maximumEvenSplit(28));
        System.out.println(c.maximumEvenSplit(30));

        System.out.println(c.maximumEvenSplit(8));
        //System.out.println(c.maximumEvenSplit(1999999998));
        //                                             1001117966

    }
}
