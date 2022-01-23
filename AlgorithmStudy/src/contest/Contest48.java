package contest;

public class Contest48 {
    public int maximumGood(int[][] statements) {

        /*
            [[2,1,2],
             [1,2,2],
             [2,0,2]]

             0번은 1번을 좋고 2번을 모르겠다고 함
             1번은 0번을 좋고 2번은 모르겠다고 함
             2번은 0번을 모르고 2번을 나쁘다고 함

             0번이 좋다면 -> 1번도 좋아야함
             1번이 나뻐야함
             1번이 나쁘다면 그 진술은 필요 없음

             1번이 좋다면 2번도 좋아야 하지만 2번이한 진술과 1번의 진술이 충돌해서 모순 발생

             고로 0, 2번이 good, 2번이 bad

             답은 2


             2 <= n <= 15
         */

        int n = statements.length;
        int[] goodBad = new int[n];
        int goodPerson = 0;
        for (int i = 0; i < n; i++) {
            // i 가 좋다는 가정하에 모순 찾기
            for (int j = 0; j < n; j++) {
                goodBad[j] = statements[i][j];
            }
            goodBad[i] = 1;
            boolean hasParadox = false;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (goodBad[j] == 1) {
                    // i가 좋다고 했을때 j는 좋아야함.
                    // 그런데 i가 측정한 값과 j 가 측정한 값이 다르면
                    // 모순이 있다는 뜻
                    for (int k = 0; k < n; k++) {
                        if (j == k) continue;

                        if (goodBad[k] == 1 && statements[j][k] == 0) {
                            hasParadox = true;
                            break;
                        }
                        if (goodBad[k] == 0 && statements[j][k] == 1) {
                            hasParadox = true;
                            break;
                        }
                    }

                    if (hasParadox) {
                        break;
                    } else {
                        // 모순이 없으면 goodBad에서 2가 있는 영역을 업데이트 해줘야함.
                        for (int k = 0; k < n; k++) {
                            if (goodBad[k] == 2) {
                                goodBad[k] = statements[j][k];
                            }
                        }
                    }
                }
            }

            if (!hasParadox) {
                goodPerson = 0;
                boolean hasNo = false;
                for (int k = 0; k < n; k++) {
                    if (goodBad[k] == 1) {
                        goodPerson++;
                    } else if (goodBad[k] == 2) {
                        hasNo = true;
                        break;
                    }

                }
                if (!hasNo) {
                    break;
                }
            }
        }

        return goodPerson;
    }


    public static void main(String[] args) {
        Contest48 c = new Contest48();

    }
}
