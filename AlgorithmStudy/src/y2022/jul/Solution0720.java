package y2022.jul;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/number-of-matching-subsequences/
public class Solution0720 {

    class CharIndexList {
        int listIdx = 0;
        List<Integer> idxList = new ArrayList<>();

        int getIdxChar(int idx) {

            for (; listIdx < idxList.size(); listIdx++) {
                if (idx <= idxList.get(listIdx)) {
                    return idxList.get(listIdx);
                }
            }

            return -1;
        }
    }

    public int numMatchingSubseq(String s, String[] words) {

        /*
        words 에서 s의 subsequence 의 수를 세기

        subsequence : s 의 순서를 변경하지 않고 char를 추출해서 만들 수 있는 문자열
         */

        int ans = 0;

        Map<Character, CharIndexList> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!map.containsKey(ch)) {
                map.put(ch, new CharIndexList());
            }
            map.get(ch).idxList.add(i);
        }

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int sIndex = 0;
            boolean isSubseq = true;
            for (int j = 0; j < word.length(); j++) {
                char ch = word.charAt(j);
                if (!map.containsKey(ch)) {
                    isSubseq = false;
                    break;
                }
                CharIndexList list = map.get(ch);
                int idx = list.getIdxChar(sIndex);
                if (idx >= 0) {
                    sIndex = idx + 1;
                } else {
                    isSubseq = false;
                    break;
                }
            }
            if (isSubseq) {
                System.out.println(word);
                ans++;
            }

            // 다시 초기화
            map.forEach((a, b) -> {
                b.listIdx = 0;
            });
        }

        return ans;
    }

    public static void main(String[] args) throws Exception {
        Solution0720 s = new Solution0720();

        //System.out.println(s.numMatchingSubseq("abcde", new String[]{"a","bb","acd","ace"}));

        System.out.println(s.numMatchingSubseq("dsahjpjauf", new String[]{"ahjpjau","ja","ahbwzgqnuk","tnmlanowax"}));
    }



}
