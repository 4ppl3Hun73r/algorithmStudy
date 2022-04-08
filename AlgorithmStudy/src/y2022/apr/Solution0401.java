package y2022.apr;

// https://leetcode.com/problems/reverse-string/
public class Solution0401 {
    public void reverseString(char[] s) {

        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right --;
        }

    }
    
    public static void main(String[] args) throws Exception {
        Solution0401 s = new Solution0401();
        
        System.out.println();
    }
}
