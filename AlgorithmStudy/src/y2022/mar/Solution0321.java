package y2022.mar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/partition-labels/
public class Solution0321 {
    public List<Integer> partitionLabels(String s) {
        /*
        ababcbacadefegdehijhklij
        모든 글자가 한번이상은 포함되게, 가장 많이 쪼개야 함.
        ababcbaca
                 defegde
                        hijhklij
         */
        List<Integer> ans = new ArrayList<>();
        Map<Character, Integer> lastIndexMap = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            lastIndexMap.put(c, i);
        }

        int count = 0;
        int lastIndex = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            lastIndex = Math.max(lastIndex, lastIndexMap.get(c)); // bb
            count++;
            if (i == lastIndex) {
                ans.add(count);
                count = 0;
            }
        }

        return ans;
    }

    public static void main(String[] args) throws Exception {
        Solution0321 s = new Solution0321();
        // 9 7 8
        System.out.println(s.partitionLabels("ababcbacadefegdehijhklij"));
    }
}
