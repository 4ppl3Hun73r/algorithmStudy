package y2021.dec;

// https://leetcode.com/problems/decode-string/
public class Solution1219 {
    String globalS;
    public String decodeString(String s) {

        char[] arr = s.toCharArray();
        globalS = s;

        return decode(arr, 0);
    }
    int i = 0;

    private String decode(char[] arr, int index) {
        StringBuffer sb = new StringBuffer();

        for (i = index; i < arr.length; i++) {
            if (Character.isDigit(arr[i])) {
                int digitEnd = i;
                for (int j = i; j < arr.length; j++) {
                    if (Character.isDigit(arr[j])) {
                        digitEnd ++;
                    } else {
                        break;
                    }
                }
                int digit = Integer.parseInt(globalS.substring(i, digitEnd));
                String dec = decode(arr, digitEnd + 1);
                for (int j = 0; j < digit; j++) {
                    sb.append(dec);
                }
            } else if (arr[i] == ']') {
                return sb.toString();
            } else {
                sb.append(arr[i]);
            }
        }

        return sb.toString();
    }
}
