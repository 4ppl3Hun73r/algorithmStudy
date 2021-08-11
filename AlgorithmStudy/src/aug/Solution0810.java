package aug;

// https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/614/week-2-august-8th-august-14th/3875/
public class Solution0810 {

    public String addStrings(String num1, String num2) {

        // 라이브러리 사용안하고 숫자 더하기
        // n1 + n2 => (n1 + n2)%10 => 해당자리수에 값이
        // (n1 + n2)/10 => carry

        // result = (num1.charAt(0) + num2.charAt(0) + carry) % 10;
        // carry = (num1.charAt(0) + num2.charAt(0)) / 10;

        // 1번 긴거를 찾아서. 돌리면 되지 않나?
        // 2. i, j 선언 할건데, sum 할떄 i, j가 bound 벗어나면 0으로 처리해서 sum 되지 않나.

        // num1 = [99]
        // num2 = [99]
        // char = '0' => 48 , '1' => 49
//        num1[0], num2[1]
        int length = Math.max(num1.length(), num2.length());
        int carry = 0;
        String result = "";
        for (int i = 1; i <= length; i++) { // bb
            int n1 = (num1.length() >= i ? num1.charAt(num1.length() - i) : '0') - '0';
            int n2 = (num2.length() >= i ? num2.charAt(num2.length() - i) : '0') - '0';

            int sum = (n1 + n2 + carry);
            int r = sum % 10;
            carry = sum / 10;
            result = r + result; // 1의자리, 10의 자리, 100의 자리
        }

        if (carry > 0) {
            result = carry + result;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution0810 s = new Solution0810();
        System.out.println(s.addStrings("0", "1"));
        System.out.println(s.addStrings("10", "99"));
        System.out.println(s.addStrings("999", "99"));
        System.out.println(s.addStrings("2874914124871", "9893798324"));
    }
}
