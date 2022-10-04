package y2022.sep;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// https://leetcode.com/problems/find-k-closest-elements/
public class Solution0929 {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        /*
        정렬된 arr 에서 x와 가까운 값을 k 개 꺼네기

        가깝다 판별
        | a - x | < | b - x |
        or | a - x | == | b - x | 이면 a < b
         */

        Comparator<Integer> comparator = (a, b) -> {
            int absA = Math.abs(a - x);
            int absB = Math.abs(b - x);

            if (absA == absB) {
                return a - b;
            }

            return absA - absB;
        };

        return Arrays.stream(arr)
                .boxed()
                .sorted(comparator)
                .limit(k)
                .sorted()
                .collect(Collectors.toList());
    }
}
