package y2021.sep;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/639/week-4-september-22nd-september-28th/3984/
public class Solution0923 {

    Map<String, Integer> cache = new HashMap<>();

    public int maxLength(List<String> arr) {
        if (arr.size() == 1) return arr.get(0).length();

        return maxLen(arr, 0, new int[26]);
    }

    private int maxLen(List<String> arr, int index, int[] alphabet) {
        if (index >= arr.size()) {
            return 0;
        }

        String key = "" + index + ":" + Arrays.toString(alphabet);
        //System.out.println(key);
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        String s = arr.get(index);
        boolean checkDup = false;
        int result = Integer.MIN_VALUE;
        int[] alphabetMerge = Arrays.copyOf(alphabet, 26);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int idx = c - 'a';
            alphabetMerge[idx] ++;
            if (alphabetMerge[idx] > 1) {
                // 중복 있음
                checkDup = true;
                break;
            }
        }

        // arr[0] + arr[1] -> 중복이면 arr[0] + arr[2] 확인, arr[1] + arr[2] 확인
        // arr[0] + arr[1] -> 중복이 없으면 arr[0] + arr[1] + arr[2] 확인, arr[1] + arr[2] 확인
        if (checkDup == false) {
            // (arr[0] + arr[1]) + arr[2] ... 확인
            // (alphabet) + arr[2]
            result = s.length() + maxLen(arr, index + 1, alphabetMerge);
            //System.out.println("dup : " + result);
        }
        // arr[1] + arr[2] 확인
        // (alphabet) + arr[2] 확인
        result = Math.max(result, maxLen(arr, index + 1, alphabet));
        //System.out.println(result);

        // cache 처리
        cache.put(key, result);

        return result;
    }


    public static void main(String[] args) {
        Solution0923 s = new Solution0923();

        System.out.println(s.maxLength(Arrays.asList("un","iq","ue")));
        System.out.println(s.maxLength(Arrays.asList("aa","bb","cc")));
        System.out.println(s.maxLength(Arrays.asList("a","b","c")));
    }
}
