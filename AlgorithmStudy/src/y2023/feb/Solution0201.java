package y2023.feb;

// https://leetcode.com/problems/greatest-common-divisor-of-strings/
public class Solution0201 {
    public String gcdOfStrings(String str1, String str2) {
        // s / t -> s = t + t + t + t ...
        // str1, str2 를 모두 나룰 수 있는 가장 큰 x 를 찾아라.

        // str1 -> x + x ...
        // str2 -> x  ..

        // ax , bx -> a 와 b의 최소 공배수 값 ->  가장 큰 x

        // x 가 아닌 다른 값이 포함되어 있음
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        int g = gcd(str1.length(), str2.length());

        return str1.substring(0, g);

    }

    private int gcd(int a, int b){
        if(b == 0){
            return a;
        } else{
            return gcd(b, a%b);
        }
    }
}
