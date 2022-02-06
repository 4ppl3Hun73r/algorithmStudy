package contest;

import java.util.HashSet;
import java.util.Set;

public class Contest55 {
    public int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {

        // targetSeconds -> 다양한 입력 방법으로 변환 해야함
        /*
        1 <= targetSeconds <= 6039
        1초 <= targetSeconds <= 100분 39초
        8090 == 8130

        530 -> 0930, 0890,
        600 -> 1000, 0960, 960
        601 -> 1001, 0961, 961
        660 -> 1100, 1060,
        6039 -> 9999
        6038 -> 9998
        6000 -> 9960
        5999 -> 9959
         */
        Set<String> timerInput = new HashSet<>();

        int min = targetSeconds / 60;
        int second = targetSeconds % 60;
        // 6000 이상에 대한  예외 처리
        if (min == 100) {
            min --;
            second = second + 60;
        }

        if (min == 0) {
            timerInput.add(String.format("00%02d", second));
            timerInput.add(String.format("0%02d", second));
            timerInput.add(String.format("%02d", second));
            timerInput.add(String.format("%d", second));
        } else {
            timerInput.add(String.format("%d%02d", min, second));
            if (min < 10) {
                timerInput.add(String.format("0%d%02d", min, second));
            }

            if (second <= 39) {
                min--;
                second = second + 60;
                if (min == 0) {
                    timerInput.add(String.format("00%02d", second));
                    timerInput.add(String.format("0%02d", second));
                    timerInput.add(String.format("%02d", second));
                    timerInput.add(String.format("%d", second));
                } else {
                    timerInput.add(String.format("%d%02d", min, second));
                    if (min < 10) {
                        timerInput.add(String.format("0%d%02d", min, second));
                    }
                }
            }
        }

        int cost = Integer.MAX_VALUE;
        for (String s : timerInput) {
            cost = Math.min(cost, calcCost(startAt, moveCost, pushCost, s));
            System.out.println(s + ": " + calcCost(startAt, moveCost, pushCost, s));
        }



        return cost;
    }

    private int calcCost(int startAt, int moveCost, int pushCost, String num) {
        int cost = 0;
        for (int i = 0; i < num.length(); i++) {
            int n = num.charAt(i) - '0';
            if (startAt == n) {
                cost += pushCost;
            } else {
                startAt = n;
                cost += moveCost + pushCost;
            }
        }

        return cost;
    }



    public static void main(String[] args) {
        Contest55 c = new Contest55();

        /*c.minCostSetTime(0, 0, 0, 590);
        c.minCostSetTime(0, 0, 0, 540);
        c.minCostSetTime(0, 0, 0, 600);
        c.minCostSetTime(0, 0, 0, 6039);
        c.minCostSetTime(0, 0, 0, 5999);
        c.minCostSetTime(0, 0, 0, 5669);*/

        System.out.println(c.minCostSetTime(0, 1, 4, 79));
    }
}
