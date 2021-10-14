package problems;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/combinations/
public class Combinations {
    List<List<Integer>> result;


    public List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            List<Integer> c = new ArrayList<>(k);
            c.add(i);
            combination(i + 1, n, k - 1, c);
        }

        return result;
    }

    private void combination(int start, int n, int k, List<Integer> c) {
        if (k == 0) {
            result.add(new ArrayList<>(c));
        }

        for (int i = start; i <= n; i++) {
            c.add(i);
            combination(i + 1, n, k - 1, c);
            c.remove(c.size() - 1);
        }
    }


    public List<List<Integer>> combine2(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (k > n || k < 0) {
            return result;
        }
        if (k == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }
        result = combine(n - 1, k - 1);
        for (List<Integer> list : result) {
            list.add(n);
        }
        result.addAll(combine(n - 1, k));
        return result;
    }

    public static void main(String[] args) {
        Combinations c = new Combinations();
        System.out.println(c.combine(4, 2));
        System.out.println(c.combine(1, 1));

        long now = System.currentTimeMillis();
        System.out.println(c.combine(20, 11));
        System.out.println("time: " + (System.currentTimeMillis() - now));
        now = System.currentTimeMillis();
        System.out.println(c.combine2(20, 11));
        System.out.println("time: " + (System.currentTimeMillis() - now));

    }
}
