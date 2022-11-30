package y2022.nov;

import java.util.Stack;

// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
public class Solution1110 {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder(stack.size());
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }

    public String removeDuplicatesQ(String s) {
        int i = 0;
        int len = s.length();

        char arr[] = s.toCharArray();
        for(int j = 0; j<len; j++){
            arr[i] = arr[j];
            if(i>0 && arr[i]==arr[i-1]){
                i -= 2;
            }
            i++;
        }
        return new String(arr, 0, i);
    }

    public String removeDuplicatesSb(String s) {
        StringBuilder sb = new StringBuilder();
        int sbLength = 0;
        for (char character : s.toCharArray()) {
            if (sbLength != 0 && character == sb.charAt(sbLength - 1)) {
                sb.deleteCharAt(sbLength - 1);
                sbLength--;
                continue;
            }
            sb.append(character);
            sbLength++;
        }
        return sb.toString();
    }
}
