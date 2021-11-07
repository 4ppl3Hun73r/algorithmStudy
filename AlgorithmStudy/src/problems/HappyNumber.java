package problems;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/happy-number/
public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> hashSet = new HashSet<>();

        do {
            hashSet.add(n);
            int v = n;
            int sum = 0;
            do {
                int mod = v % 10;
                sum += mod * mod;
                v = v / 10;
            } while (v != 0);
            System.out.println(sum);
            n = sum;
            if (n == 1) {
                return true;
            }
        } while(!hashSet.contains(n));

        return false;
    }

    public static void main(String[] args) {
        HappyNumber h = new HappyNumber();

        //System.out.println(h.isHappy(19));
        System.out.println(h.isHappy(2));
    }
}

