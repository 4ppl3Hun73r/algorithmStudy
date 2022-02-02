package y2022.feb;

import java.util.ArrayList;
import java.util.List;

public class Solution0202 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) {
            return result;
        }
        int[] pHash = new int[26];
        for (char c : p.toCharArray()) {
            pHash[c - 'a']++;
        }

        int start = 0; // 슬라이딩 윈도우 시작
        int end = 0; // 슬라이딩 윈도우 끝
        int count = p.length();

        while (end < s.length()) {
            if (pHash[s.charAt(end) - 'a'] >= 1) {
                count--; // 해당 글자가 a에 존재함.
            }
            pHash[s.charAt(end) - 'a']--;  // 존재하든 안하든 하나 제거
            end++; // 윈도우 전진

            if (count == 0) { // 모든 걸 찾았으면 결과에 추가
                result.add(start);
            }

            if (end - start == p.length()) { // 윈도우 길이가 같으면 왼쪽값을 복원 시킴
                if (pHash[s.charAt(start) - 'a'] >= 0) {
                    count++;
                }
                pHash[s.charAt(start) - 'a']++;
                start++;
            }
        }

        return result;
    }
}
