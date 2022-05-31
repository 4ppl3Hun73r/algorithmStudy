package y2022.jan;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/palindrome-partitioning/
public class Solution0105 {
    List<List<String>> result;

    public List<List<String>> partition(String s) {
        /*
        나올수 있는 모든 회문의 조합을 반환
        "aab" => [a, a, b], [aa, b]
        "a" => [a]
        1 <= s.length <= 16

        aab -> a / ab
         ab -> a / b
          b -> b

        aab -> aa / b
          b -> b

        "aaabbbcccc" => 답이 너무 김..

        "abaaa" => [a, b, aaa], [a, b, a, aa], [a, b, a, a, a], [a, b, aa, a]
        [a, b, a, a, a], [a, b, a, aa], [a, b, aa, a], [a, b, aaa]

        leetcode : [
            ["a","b","a","a","a"],
            ["a","b","a","aa"],
            ["a","b","aa","a"],
            ["a","b","aaa"],
            ["aba","a","a"],
            ["aba","aa"]
        ]

        언어 특성일까요?
        aba -> 엘리스 -> 어린이 동화책 -> 회문이 나오니까.
        토마토, 오디오,
         "Was it a cat I saw?"
        Dog Sees Ada

        Adam? I'm Adam! Moody, me? Dam it (sic)! Are we all? I know Ada. I saw Ada.

        Ah, a short symbol to no denial: Eyes omit naive dog-desserts. Evil right, old-name diets. A tree-bonnet foliate, relax: If Ada did pull order, read. Ada had a foe, fire-rose facade tool, too-hot yard Iraq: arid Elijah at a haj. I lead a reviled noose, Canadian!

        It is coded, on a pistol by Rome, "Man is an ardor pelt, tactiler, sad." A tacit sin, a rude Roman enema. I ran; Agnus Dei, Dada lived on.
        I, a gap, a zero monad, Ada's nose: "Rift on, evil royal pilots!" I pass a nasal acolyte. I pondered, now idle.
        His flack: late no-nos, tits, a cow. Two-cow, to tenor of God! A sin is a sign, ignoble udder-cases! La femme fatale gnawed at a phone-post, also lost call, eh? She'll act solo, slats op en. Oh, pat a dew-angel at a femme false. Sacred duel, bonging is a sin; is a dog? For one to two-cow two, cast it so none talk calfs!

        I held, I wondered. No piety local as an ass. A pistol (I play, or live not) fires on sad Ada. "No more!" Zap! Again. O devil! Ada died, sung an aria. Men, enamored, uranistic at Ada's relit cattle prod, ran as in a memory blot.

        Sip an ode, Doc; sit in. Aid an ace, soon deliver Ada! Elijah!

        At a haj, I led Iraq (arid ray to hoot), looted a cafe sore, rife of Ada. Had Ada erred? Roll up. Did Ada fix ale, retail? Often. "No beer taste," I demand, "loth girl! I've stressed! Go, deviant!"

        "I mosey!"
        "Elaine, Do not lob my Stroh's!"
        Aha! Ada was I; Ada won. Kill a ewe, racist.
        I made my doom: "Madam, I'm ADA!"
        Ada sees God.

         */
        result = new ArrayList<>();
        helper(s, 0, new ArrayList<>());
        return result;
    }

    private void helper(String s, int start, List<String> subList) {
        if (start == s.length()) {
            result.add(new ArrayList<>(subList));
            return;
        }

        for (int i = start; i < s.length(); i++) { //??
            /*
            abaaa
             [a]
             baaa
             [a,b]
              aaa
              [a,b,a]
               aa
               [a,b,a,a]
                a
                 [a,b,a,a,a]
                 ""
                  [a,b,a,a,a] => result에 들어가는 시점
                 [a,b,a,a]
                aa
                 [a,b,a,aa]
                 ""
                  [a,b,a,aa] => result
                 [a,b,a]
                [a,b]
                 [a,b,aaa]

             */
            /* OH... bb
               a,dp[start+1][end-1],a => 회문이 되요.
               aaaabaaaa
                  ^^^

                if (s.charAt(start) == s.charAt(end)
                    && (end - start <= 2 || dp[start + 1][end - 1])) {
                    dp[start][end] = true;
             */
            if (isPalindrome(s, start, i)) {
                String p = s.substring(start, i + 1);
                subList.add(p);
                helper(s, i + 1, subList);
                subList.remove(subList.size() - 1); // remove 이해안감.
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) { // check
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // private void find(

    public static void main(String[] args) throws Exception {
        Solution0105 s = new Solution0105();

        //System.out.println(s.partition("abaaa"));
        System.out.println(s.partition("abaaaba"));
        System.out.println(s.partition("abaaab"));
        /*
        [[a, b, a, a, a, b, a], [a, b, a, a, aba], [a, b, a, aa, b, a], [a, b, aa, a, b, a], [a, b, aa, aba], [a, b, aaa, b, a], [a, baaab, a], [aba, a, a, b, a], [aba, a, aba], [aba, aa, b, a], [abaaaba]]
        [["a","b","a","a","a","b","a"],["a","b","a","a","aba"],["a","b","a","aa","b","a"],["a","b","aa","a","b","a"],["a","b","aa","aba"],["a","b","aaa","b","a"],["a","baaab","a"],["aba","a","a","b","a"],["aba","a","aba"],["aba","aa","b","a"],["abaaaba"]]

        [[a, b, a, a, a, b], [a, b, a, aa, b], [a, b, aa, a, b], [a, b, aaa, b], [a, baaab], [aba, a, a, b], [aba, aa, b]]
        [["a","b","a","a","a","b"],["a","b","a","aa","b"],["a","b","aa","a","b"],["a","b","aaa","b"],["a","baaab"],["aba","a","a","b"],["aba","aa","b"]]
         */
    }

}
