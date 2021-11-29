package problems;

public class FindTheTownJudge {
    public int findJudge(int n, int[][] trust) {
        // 판사는 모두를 믿지 않음
        // 주민은 모두 판사를 믿음
        // 판사를 특정 지을수 있으면 해당 n
        // 판사가 없거나, 특정 지을수 없으면 -1
        int[] candidate = new int[n + 1];

        for (int[] ab : trust) {
            candidate[ab[0]]--;
            candidate[ab[1]]++;
        }

        n--;
        for (int i = 1; i < candidate.length; i++) {
            if (candidate[i] == n) {
                return i;
            }
        }

        return -1;
    }
}
