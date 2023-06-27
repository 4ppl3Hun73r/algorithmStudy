package y2023.apr;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

// https://leetcode.com/problems/optimal-partition-of-string/
public class Solution0404 {
    public int partitionString(String s) {
        /*
        s 를 쪼개는데, 안에 중복되는 letter 가 없게 쪼개기

        abacaba
        ab a cab a
        a bac a ba
        a ba ca ba -> minimun -> 4개

        a b a c a b a
         */
        int ans = 1;

        Set<Character> map = new HashSet<>();

        for(int i = 0; i < s.length(); i++) {
            if (map.contains(s.charAt(i))) {
                ans++;
                map.clear();
            }
            map.add(s.charAt(i));
        }
        return ans;
    }

    public int partitionString2(String s) {
        /*
        s 를 쪼개는데, 안에 중복되는 letter 가 없게 쪼개기

        abacaba
        ab a cab a
        a bac a ba
        a ba ca ba -> minimun -> 4개

        a b a c a b a
         */
        int ans = 1;

        boolean[] alphabet = new boolean[26];

        for (char c : s.toCharArray()) {
            if (alphabet[c - 'a']) {
                ans++;
                Arrays.fill(alphabet, false);
            }
            alphabet[c - 'a'] = true;
        }

        return ans;
    }

    public static void main(String[] args) throws Exception {
        Solution0404 s = new Solution0404();

        StringBuilder sb = new StringBuilder(100000);
        Random random = new Random();
        for (int i = 0; i < 3750; i++) {
            sb.append((char)(random.nextInt(26) + 'a'));
        }

        String s1 = sb.toString();
        System.out.println(s1);
        long time = System.currentTimeMillis();
        System.out.println(s.partitionString2(s1));
        System.out.println(System.currentTimeMillis() - time);

        time = System.currentTimeMillis();
        System.out.println(s.partitionString(s1));
        System.out.println(System.currentTimeMillis() - time);
    }
}
