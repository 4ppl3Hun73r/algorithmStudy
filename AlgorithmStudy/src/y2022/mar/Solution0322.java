package y2022.mar;

// https://leetcode.com/problems/smallest-string-with-a-given-numeric-value/
public class Solution0322 {

    public String getSmallestString(int n, int k) {
        /*
         k를 다 사용해서 n 길이의 문자를 만드는 거죠
         a : 1 ~ z : 26

         조건이 lexicographically smallest string 으로 만드세요.

         n = 3, k = 27
         aay

         n = 5, k = 73
         aaszz a + a + s + z + z => 73

         [26][26][26] 81
         k = 70
         [16][26][26]
         k = 54
         [1][26][26]
         */
        StringBuilder sb = new StringBuilder();

        /*
        i = 3) k =  73- (2 * 27)


        aaaaaaaa(b~y)zzzzzzzz

         */

        for (int i = n; i > 0; i--) {
            int temp = k - ((i - 1) * 26); // 'z' 26
            if (temp <= 0) { // 71 >
                sb.append('a');
                k = k - 1;
            } else {
                sb.append((char)('a' + (temp - 1))); // 1 ~ 26 가 되지 않을까요?
                k = k - temp;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        Solution0322 s = new Solution0322();

        System.out.println(s.getSmallestString(3, 27));
        System.out.println(s.getSmallestString(5, 73));
    }
}
