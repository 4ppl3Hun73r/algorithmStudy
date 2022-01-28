package y2022.jun;

// https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/
public class Solution0127 {
    public int findMaximumXOR(int[] nums) {
        /*
        [0000, 1000, 1111, 1100]
        [      1000, 1111, 0100]
        [1000,       0111, 0100]
        [1111, 0111,       0011]
        [1100, 0100, 0011,     ]

        3 : 00011
        5 : 00101
        25: 11001
            11100
            01010
            10101
         */

        // trie 로 구조 생성
        Trie root = new Trie();
        for (int num : nums) {
            Trie curNode = root;
            for(int i = 31; i >= 0; i--) {
                int curBit = (num >>> i) & 1;
                if(curNode.children[curBit] == null) {
                    curNode.children[curBit] = new Trie();
                }
                curNode = curNode.children[curBit];
            }
        }


        int max = Integer.MIN_VALUE;
        for(int num: nums) {
            Trie curNode = root;
            int curSum = 0;
            for(int i = 31; i >= 0; i --) {
                int curBit = (num >>> i) & 1;
                if(curNode.children[curBit ^ 1] != null) {
                    curSum += (1 << i);
                    curNode = curNode.children[curBit ^ 1];
                }else {
                    curNode = curNode.children[curBit];
                }
            }
            max = Math.max(curSum, max);
        }
        return max;
    }

    class Trie {
        Trie[] children;
        public Trie() {
            children = new Trie[2];
        }
    }

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 200000; i++) {
            System.out.printf("%d,", 1);
        }
    }
}
