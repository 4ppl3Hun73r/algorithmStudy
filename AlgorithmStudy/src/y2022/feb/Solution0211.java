package y2022.feb;

// https://leetcode.com/problems/permutation-in-string/
public class Solution0211 {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        /*
        s1이 s2에 포함되는지 확인
        s1은 permutation 가능
         abc -> abc, acb, bca, bac, cab, cba ...
         */
        // sliding windows ->
        // aaaaaaaacccaaaabaaaccc
        //              [ab] -> sliding window -> (for -> 26) check를 위해서
        int[] map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            map[s1.charAt(i) - 'a'] ++;
            map[s2.charAt(i) - 'a'] --;
        }
        for (int i = s1.length(); i < s2.length(); i++) {
            boolean check = true;
        /*
        ab
        eidbaooo
          [  ]
        map [1,1,...-1, -1..]
        O(26 * N) => O(N)
        O(100000000 * N) 상수가 N보다 크면
        O(N * N)

        O(100000000 * N) < O(N*N) ? N < 100000000

        최악의 브루트포스 => O(N!)
         */
            for (int j = 0; j < 26; j++) {
                if (map[j] != 0) {
                    check = false;
                    break;
                }
            }
            if (check) return true;
            map[s2.charAt(i - s1.length()) - 'a'] ++;
            map[s2.charAt(i) - 'a'] --;

            /*

             0123456789
             abcdefghij
                      ^
             */
        }
        boolean check = true;
        for (int j = 0; j < 26; j++) {
            if (map[j] != 0) {
                check = false;
                break;
            }
        }

        return check;
    }

    private long sum(int[] nums) {
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        return sum;
    }

    private long sumConst(int[] nums) {
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 10000; j++) {
                nums[i] += j;
            }
            sum += nums[i];
        }

        return sum;
    }

    private long sumNN(int[] nums) {
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                nums[i] += j;
            }
            sum += nums[i];
        }

        return sum;
    }

    public static void main(String[] args) throws Exception {
        Solution0211 s = new Solution0211();

        int[] nums = new int[10000];
        long time = System.nanoTime();
        s.sum(nums);
        System.out.println("O(N) : " + (System.nanoTime() - time));

        time = System.nanoTime();
        s.sumConst(nums);
        System.out.println("O(10000 * N) : " + (System.nanoTime() - time));

        time = System.nanoTime();
        s.sumNN(nums);
        System.out.println("O(N * N) : " + (System.nanoTime() - time));
        /*
        어셈레벨로
        N * N -> 참조 한번 더 해서 조금 느리긴 할것 같은데...
        N * 10000
         */
    }
}
