package y2022.aug;

// https://leetcode.com/problems/ransom-note/
public class Solution0825 {

    public boolean canConstruct(String ransomNote, String magazine) {
        /*
        magazine을 통해서 ransomNote 를 만들 수 있는가?
         */
        int[] map = new int[26];

        for (char c : magazine.toCharArray()) {
            map[c - 'a']++;
        }


        for (char c : ransomNote.toCharArray()) {
            map[c - 'a']--;
            if (map[c - 'a'] < 0)
                return false;
        }
//"aa"
//"aab"
        return true;
    }
}
