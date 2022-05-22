package problems;

// https://leetcode.com/problems/find-the-k-beauty-of-a-number/
public class FindTheKBeautyOfANumber {
    public int divisorSubstrings(int num, int k) {

        int ans = 0;
        String str = String.valueOf(num);

        int len = str.length() - k + 1;
        for (int i = 0; i < len; i++) {
            int subNum = Integer.parseInt(str.substring(i, i + k));
            System.out.println(subNum);

            if (subNum == 0) {
                continue;
            }
            if (num % subNum == 0) {
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        FindTheKBeautyOfANumber f = new FindTheKBeautyOfANumber();

        System.out.println(f.divisorSubstrings(430043, 2));
    }
}
