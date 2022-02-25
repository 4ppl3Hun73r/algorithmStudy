package y2022.feb;

// https://leetcode.com/problems/compare-version-numbers/
public class Solution0225 {
    public int compareVersion(String version1, String version2) {
        /*
        If version1 < version2, return -1.
        If version1 > version2, return 1.
        Otherwise, return 0.

        1.01 == 1.001

        1.0 == 1.0.0

        0.1 < 1.1

        // All the given revisions in version1 and version2 can be stored in a 32-bit integer.
         */

        String[] version1Arr = version1.split("\\.");
        String[] version2Arr = version2.split("\\.");
        java.util.StringTokenizer st1 = new java.util.StringTokenizer(version1, ".");
        java.util.StringTokenizer st2 = new java.util.StringTokenizer(version2, ".");

        while (st1.hasMoreTokens() || st2.hasMoreTokens()) {
            String s1 = "0";
            String s2 = "0";
            if (st1.hasMoreTokens()) {
                s1 = st1.nextToken();
            }
            if (st2.hasMoreTokens()) {
                s2 = st2.nextToken();
            }
            /*
            1, 11211.....1
            1, 02111.....1
             */
            int v1 = Integer.parseInt(s1, 10);
            int v2 = Integer.parseInt(s2, 10);

            if (v1 == v2) continue;

            return v1 < v2 ? -1 : 1;
            // System.out.println(s1);
            // System.out.println(s2);
        }

        return 0;
    }

    public static void main(String[] args) throws Exception {
        Solution0225 s = new Solution0225();
        System.out.println(s.compareVersion("1.11211", "1.211"));
    }
}
