package problems;

// https://leetcode.com/problems/reverse-bits/
public class ReverseBits {

    public int reverseBits(int n) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            result = (result << 1) | (n & 1); // result를 한칸 옆으로 옮기고 마지막 n의 마지막 bit를 복사해옴
            n = n >> 1; // n을 왼쪽으로 한칸 이동
        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        ReverseBits r = new ReverseBits();
        System.out.println(r.reverseBits(43261596)); // 964176192
    }
}
