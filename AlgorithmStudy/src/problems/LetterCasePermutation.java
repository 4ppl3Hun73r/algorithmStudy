package problems;


import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/letter-case-permutation/
public class LetterCasePermutation {
    List<String> result;
    public List<String> letterCasePermutation(String s) {
        result = new ArrayList<>();
        char[] arr = s.toCharArray();
        // result.add(s);

        permutation(arr, 0);

        return result;
    }

    private void permutation(char[] arr, int start) {

        for (int i = start; i  < arr.length; i++) {
            if (i == arr.length - 1) {
                if (Character.isAlphabetic(arr[i])) {
                    arr[i] = Character.toLowerCase(arr[i]);
                    result.add(new String(arr));

                    arr[i] = Character.toUpperCase(arr[i]);
                    result.add(new String(arr));
                } else {
                    result.add(new String(arr));
                }

            } else {
                if (Character.isAlphabetic(arr[i])) {
                    arr[i] = Character.toLowerCase(arr[i]);
                    // 소문자로 한번 찾기
                    permutation(arr, i + 1);

                    // 대문자로 한번 더 찾기
                    arr[i] = Character.toUpperCase(arr[i]);
                    permutation(arr, i + 1);
                    break;
                }
            }
        }
    }
}
