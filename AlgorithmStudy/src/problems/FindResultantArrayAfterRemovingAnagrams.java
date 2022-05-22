package problems;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/find-resultant-array-after-removing-anagrams/
public class FindResultantArrayAfterRemovingAnagrams {

    public List<String> removeAnagrams(String[] words) {
        List<String> ans = new ArrayList<>();

        int[] arr = new int[26];
        int[] arr2 = new int[26];

        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                arr2[word.charAt(i) - 'a']++;
            }

            boolean same = true;
            for (int i = 0; i < 26; i++) {
                if (arr[i] != arr2[i]) {
                    same = false;
                    break;
                }
            }

            if (!same) {
                ans.add(word);
            }

            arr = arr2;
            arr2 = new int[26];
        }

        return ans;
    }
}
