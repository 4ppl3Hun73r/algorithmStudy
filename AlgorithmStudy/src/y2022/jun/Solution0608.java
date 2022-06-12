package y2022.jun;

// https://leetcode.com/problems/remove-palindromic-subsequences/
public class Solution0608 {
    public int removePalindromeSub(String s) {
        /*
        a, b 로 이루어진 스트링인데 회문이면 제거 가능
        최소한의 회문 제거를 통해서 "" 로 만들 수 있는가?

        그런데 하위 시퀀스가 꼭 연속일 필요가 없다.
        abaabbabaababababa
         -> a를 다 지우고, b를 다 지우면 됨
         -> 전체가 회문이다 return 1
         -> 전체가 회문이 아니다. return 2
         */
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return 2;
            }
            left++;
            right--;
        }

        return 1;
    }
}
