package problems;

// https://leetcode.com/problems/ransom-note/
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26];

        for(char c : ransomNote.toCharArray()) {
            arr[c - 'a']++;
        }

        for(char c : magazine.toCharArray()) {
            arr[c - 'a']--;
        }

        boolean result = true;
        for (int i : arr) {
            if (i > 0) {
                result = false;
                break;
            }
        }

        return result;
    }
}
