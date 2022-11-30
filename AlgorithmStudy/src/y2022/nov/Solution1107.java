package y2022.nov;

// https://leetcode.com/problems/maximum-69-number/
public class Solution1107 {
    public int maximum69Number (int num) {
        /*
        %, /
        -> 앞에서 부터 찾을 방법?
        -> 자릿수를 알아야하는데
        String
         */
        return Integer.parseInt(String.valueOf(num)
                .replaceFirst("6", "9"), 10);
    }
}
