package sep;

// https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/637/week-2-september-8th-september-14th/3968/
public class Solution0909 {

    public String shiftingLetters(String s, int[] shifts) {

        // shifts
        // [N] -> s[0] + N
        // [N, M, K] -> s[0] + N + M + K, s[1] + M + K, s[2] + K
        int prev = 0;
        StringBuffer sb = new StringBuffer(s.length());
        for (int i = shifts.length - 1; i >= 0; i--) {
            shifts[i] += prev%26;
            prev = shifts[i];
            char c = (char) ((s.charAt(i) - 'a' + shifts[i])%26 + 'a');
            sb.append(c);
        }

        return sb.reverse().toString();
    }

    private String jiho(String s, int[] shifts) {
        char[] charArray = s.toCharArray();
        int sum = 0;
        for (int i = shifts.length - 1; i >= 0; i--) {
            charArray[i] = (char) ((charArray[i] - 'a' + shifts[i] + sum) % 26 + 'a');
            sum += shifts[i]%26;
        }
        return new String(charArray);
    }

    private String ym(String s, int[] shifts){
        int shiftsSum = 0;
        char[] arr = s.toCharArray();
        for (int i = shifts.length - 1; i >= 0; i--) {
            int shiftsVal = shifts[i];
            shiftsSum = (shiftsVal + shiftsSum) % 26;
            char c = s.charAt(i);
            int val = c + shiftsSum;
            if (val > 122) {
                val -= 26;
            }
            char shiftedChar = (char)val;
            arr[i] = shiftedChar;
        }

        return new String(arr);

    }

    /*
        fun shiftingLetters(s: String, shifts: IntArray): String {
            val totalShifts = LongArray(shifts.size)

            for ((index, value) in shifts.withIndex()) {
                var i = index
                val shift = value.toLong()
                while (i >= 0) {
                    totalShifts[i--] += shift
                }
            }

            val offsetLetter = 'a'
            val range = 'z' - 'a' + 1

            return s.map { c -> c - offsetLetter }
                .mapIndexed { index, diff -> diff + totalShifts[index] }
                .map { shiftedDiff -> shiftedDiff % range }
                .map { actualShiftedDiff -> offsetLetter + actualShiftedDiff.toInt() }
                .joinToString(separator = "")
        }
     */


    public static void main(String[] args) {
        Solution0909 s = new Solution0909();
        System.out.println(s.shiftingLetters("ruu", new int[]{26,9,17}));
        System.out.println(s.shiftingLetters("bad", new int[]{10,20,30}));
        System.out.println(s.shiftingLetters("mkgfzkkuxownxvfvxasy", new int[]{505870226,437526072,266740649,224336793,532917782,311122363,567754492,595798950,81520022,684110326,137742843,275267355,856903962,148291585,919054234,467541837,622939912,116899933,983296461,536563513}));
    }

}
