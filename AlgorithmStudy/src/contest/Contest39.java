package contest;

public class Contest39 {
    public long mostPoints(int[][] questions) {
        /*
        question[i] = [points, brainPower]
        문제를 풀면 points를 얻고 brainPower 만큼 다음 문제 스킵

        questions.length = 100000

        dp?
          dp[] =
        skip[] =

        1번 문제를 풀면 -> N 번 후의 문제를 풀고 -> 3번 문제를 풀고 ... 마지막 문제까지 푼다.
           -> 그 값을 다 역으로 저장하면서 지나오기 dfs(?)
        2번 문제를 풀면 -> 가다가 이미 풀었으면 -> 거기서 멈춤 -> 이렇게 풀면 안됨 -> N개 스킵하고 바로 다음 문제를 푸는게 아니라 최고의 해를 찾아야함

        dp[n] -> n번쨰 문제를 풀었을때 최대 값

        dp[n] = Math.max(dp[n + question[1] + 1, question[0])

         */
        long[] dp = new long[questions.length];
        dp[questions.length - 1] = questions[questions.length - 1][0];
        long result = dp[questions.length - 1];
        for (int i = questions.length - 2; i >= 0; i--) {
            int solve = questions[i][0];
            int leftPos = i + questions[i][1] + 1;
            if (leftPos < questions.length) {
                solve += dp[leftPos];
            }
            dp[i] = Math.max(dp[i + 1], solve);
            result = Math.max(result, dp[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        Contest39 c = new Contest39();

        System.out.println(c.mostPoints(new int[][]{
                {21,5},{92,3},{74,2},{39,4},{58,2},{5,5},{49,4},{65,3}
        })); // 157

        System.out.println(c.mostPoints(new int[][]{
                {12,46},{78,19},{63,15},{79,62},{13,10}
        })); // 79


        System.out.println(c.mostPoints(new int[][]{
                {1,1},{2,2},{3,3},{4,4},{5,5}
        })); // 7

        System.out.println(c.mostPoints(new int[][]{
                {1,1},{2,1},{3,1},{4,1},{5,1}
        })); // 7
        

/*
        Random random = new Random();
        for (int i = 0; i < 100000; i++) {
            System.out.printf("[%d,%d],", random.nextInt(9) + 1, random.nextInt(100000) + 1);

        }
*/
        
        
    }
}
