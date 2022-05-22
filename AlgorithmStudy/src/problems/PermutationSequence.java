package problems;

// https://leetcode.com/problems/permutation-sequence/
public class PermutationSequence {
    /*
    "123" 1
    "132" 2
    "213" 3
    "231" 4
    "312" 5
    "321" 6

    3자리면 1로 시작하는게 2개

    솔직히 이렇게 풀면 안되는데, 그냥 통과되버림 ㅋㅋㅋ

     */

    String ans = null;
    int cnt = 0;
    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        for (int i = 1; i <= n; i++) {
            nums[i - 1] = i;
        }

        boolean[] visited = new boolean[n];
        //visited[1] = true;
        StringBuilder sb = new StringBuilder();
        //sb.append(nums[1]);
        permute(nums, visited, sb, k);

        return "";
    }

    private void permute(int[] nums, boolean[] visited, StringBuilder sb, int k) {
        if (ans != null) {
            return;
        }
        if (sb.length() == nums.length) {
            cnt++;
            if (k == cnt) {
                ans = sb.toString();
            }
            //System.out.println(sb.toString());
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sb.append(nums[i]);
                permute(nums, visited, sb, k);
                sb.deleteCharAt(sb.length() - 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        PermutationSequence ps = new PermutationSequence();

        System.out.println(ps.getPermutation(9, 3));
    }
}
