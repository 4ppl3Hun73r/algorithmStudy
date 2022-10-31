package y2022.oct;

// https://leetcode.com/problems/count-and-say/
public class Solution1018 {
    public String countAndSay(int n) {
        /*

              1
              11
              21
              1121
              122111
              112213
              12221131
         */
        if (n == 1) {
            return "1";
        }

        String input = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < input.length(); j++) {
                int count = 0;
                int k = j;
                char say = input.charAt(j);
                while (k < input.length() && input.charAt(k) == say) {
                    count++;
                    k++;
                }
                sb.append(count);
                sb.append(say);
                j = k - 1;
            }
            input = sb.toString();
        }

        return input;
    }

    public static void main(String[] args) throws Exception {
        Solution1018 s = new Solution1018();

        System.out.println(s.countAndSay(1));
        System.out.println(s.countAndSay(2));
        System.out.println(s.countAndSay(3));
        System.out.println(s.countAndSay(4));
    }
}
