package y2023.feb;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/naming-a-company/
public class Solution0209 {
    public long distinctNames(String[] ideas) {
        Set<String>[] sets = new Set[26];
        for (int i = 0; i < 26; i++) {
            sets[i] = new HashSet<>();
        }

        for (String idea : ideas) {
            char first = idea.charAt(0);
            sets[first - 'a'].add(idea.substring(1));
        }

        long answer = 0;

        for (int i = 0; i < 26; i++) {
            Set<String> set = sets[i];
            for (int j = i + 1; j < 26; j++) { //a, b, c
                long count = 0;
                for (String idea : set) {  // a -> [apple, afford, account]
                    if (sets[j].contains(idea)) {
                        count++;
                    }
                }
                answer += 2 * (sets[i].size() - count) * (sets[j].size() - count);
            }
        }

        //"coffee","donuts","time","toffee"
        //"coffee", "time" ->    ~~"toffee cime", "cime toffee"~~
        //
        /*
        c -> 3 , 2
        d -> 4 , 3

        c -> coffee
        d -> donuts
        t -> time, toffee
        coffee, doffee, toffee

        donuts, conuts, tonuts

        time, cime, dime,

        1 * 1 -> add res
        1 * 1 -> add res
        1 * 2 -> add res
        1 * 1 -> add res
        1 * 1 -> add res
        1 * 1 -> add res
        + 6 -> find answer!!!
         */


        return answer;
    }

    public static void main(String[] args) throws Exception {
        Solution0209 s = new Solution0209();

        //System.out.println(s.distinctNames(new String[]{"coffee","donuts","time","toffee"}));

        System.out.println(s.distinctNames(new String[]{"aaa","baa","caa","bbb","cbb","dbb"}));

        //aaa, dbb
        //baa, dbb

        /*Set<String> testCase = new HashSet<>();
        Random r = new Random();
        while (testCase.size() != 50000) {

            r.nextInt(26);

        }
        //["aaa","baa","caa","bbb","cbb","dbb"]
        System.out.println(testCase);*/
    }
}
