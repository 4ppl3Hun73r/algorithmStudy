package nov;

// https://leetcode.com/problems/hamming-distance/
public class Solution1119 {
    public int hammingDistance1(int x, int y) {
        int count = 0;

        for (int i = 31; i >= 0; i--) {
            if ((x & (1 << i)) != (y & (1 << i))) {
                count ++;
            }
        }
        return count;
    }

    public int hammingDistanceOneLine(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    public int hammingDistance(int x, int y) {
        // hamming distance 알고리듬
        // 단어와 단어 사이의 거리를 계산하는 알고리듬
        // abcd
        // bbcd => 거리가 1
        // aaaa
        // abcd => 거리가 3

        // 1 => 0001
        // 4 => 0010 => 거리가 2

        String xs = Integer.toBinaryString(x); // 000000000000001
        String xy = Integer.toBinaryString(y); // 000000000000010
        StringBuilder sb1 = new StringBuilder();
        for (int i = 0; i < 32 - xs.length(); i++) {
            sb1.append(0);
        }
        sb1.append(xs);
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < 32 - xy.length(); i++) {
            sb2.append(0);
        }
        sb2.append(xy);

        xs = sb1.toString();
        xy = sb2.toString();
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if (xs.charAt(i) != xy.charAt(i)) {
                count ++;
            }
        }

        return count;
    }



    public static void main(String[] args) throws Exception {
        Solution1119 s = new Solution1119();
        s.hammingDistance(Integer.MAX_VALUE, 154132314);

    }

}
