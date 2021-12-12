package contest;

import java.util.ArrayList;
import java.util.List;

public class Contest6 {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {

        int len = security.length;

        int startDay = time;
        int endDay = len - time;
        List<Integer> result = new ArrayList<>();

        if (time == 0) {
            for (int i = 0; i < len; i++) {
                result.add(i);
            }
            return result;
        }

        Integer[] leftWindow = new Integer[1];
        Integer[] rightWindow = new Integer[1];

        for (int i = startDay; i < endDay; i++) {
            System.out.println(security[i]);
            if (leftWindow[0] == null) {
                if (!checkLeft(security, i, time, leftWindow)) {
                    leftWindow[0] = null;
                    rightWindow[0] = null;
                    continue;
                }
            } else if (leftWindow[0] < security[i]) {
                leftWindow[0] = null;
                rightWindow[0] = null;
                i+= time - 1;
                continue;
            }

            if (rightWindow[0] == null) {
                if (!checkRight(security, i, time, rightWindow)) {
                    rightWindow[0] = null;
                    continue;

                }
            } else if (security[i + time] < rightWindow[0]) {
                rightWindow[0] = null;
                continue;
            }

            leftWindow[0] = security[i];
            rightWindow[0] = security[i + 1];

            result.add(i);
        }

        return result;
    }

    private boolean checkLeft(int[] security, int i, int time, Integer[] leftWindow) {
        boolean check = true;
        for(int j = i - time; j < i; j++) {
            // 언제나 감소하거나 같거나
            if (security[j] < security[j + 1]) {
                check = false;
                leftWindow[0] = null;
                break;
            }
            leftWindow[0] = security[j];
        }

        return check;
    }

    private boolean checkRight(int[] security, int i, int time, Integer[] rightWindow) {
        boolean check = true;
        for(int j = i; j < i + time; j++) {
            // 언제나 증가 하거나 같거나
            if (security[j] > security[j + 1]) {
                check = false;
                rightWindow[0] = null;
                break;
            }
            rightWindow[0] = security[j];
        }

        return check;
    }

    public static void main(String[] args) {
        Contest6 c = new Contest6();
                                                    //   0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6
        System.out.println(c.goodDaysToRobBank(new int[]{1,2,5,4,1,0,2,4,5,3,1,2,4,3,2,4,8}, 2)); // [5,10,14]

    }
}
