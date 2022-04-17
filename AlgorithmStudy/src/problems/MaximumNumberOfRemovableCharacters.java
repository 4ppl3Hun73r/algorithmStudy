package problems;

public class MaximumNumberOfRemovableCharacters {
    public int maximumRemovals(String s, String p, int[] removable) {

        char[] sArr = s.toCharArray();
        int left = 0;
        int right = removable.length;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            for (int i = 0; i < mid; i++) {
                sArr[removable[i]] = '.';
            }

            if (checkSubsequence(sArr, p)) {
                left = mid + 1;
            } else {
                right = mid - 1;
                for (int i = 0; i < mid; i++) {
                    sArr[removable[i]] = s.charAt(removable[i]);
                }
            }
        }

        return right;
    }

    private boolean checkSubsequence(char[] sArr, String p) {
        int i = 0;
        int j = 0;

        while (i < sArr.length && j < p.length()) {
            char curr = sArr[i];
            char curr2 = p.charAt(j);
            if (curr != '.' && curr == curr2) {
                j++;
            }
            i++;
        }

        if (j == p.length()) {
            return true;
        }

        return false;
    }
}
