package y2021.aug;

// https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/612/week-5-july-29th-july-31st/3833/
public class Solution0801 {

    public int trap(int[] height) {
        // 물이 차는 조건

        // 높이로 벽을 치고, 비가 왔을때 고여 있는 비의 양을 반환

        /*
         |
         |              x
         |      x = = = x x = x
         |__x_=_x_x_=_x_x_x_x_x_x_
          0 1 2 3 4 5 6 7 8 9 1011

         height = [0,1,0,2,1,0,1,3,2,1,2,1];
         */

        // 물이 차있는 것
        // 왼쪽 < 물 < 오른쪽,  Min(왼쪽, 오른쪽)

        // 왼쪽 오른쪽 중 낮은거 까지 물이 참
        // index:left:current:right:water
        //     0:   0:      0:    1:0 => 왼쪽이 0이라서 물이 없어짐
        //     1:   0:      1:    0:0 => 왼쪽, 오른쪽이 현재보다 낮아서 물이 없어짐
        //     2:   1:      0:    2:1 => 왼쪽, 오른쪽 둘다 현재보다 높아서 둘중 MIN이 물이
        //     3:   0:      2:    1:0 => 왼쪽, 오른쪽이 현재보다 낮아서 물이 없어짐
        //     4:   2:      1:    0:1 -> 왼쪽이 현재보다 높고, 오른쪽이 낮다. 그런데 오른쪽은 물이 차올를거라서 오른쪽이 사실 높다. ==> 따라서 오른쪽을 미리 볼수 있어야함
        //     오른쪽을 따라가면서 볼수 있으나 예외 상황이 있음, 왼쪽이 높은데 오르쪽이 낮은걸로 끝날수 있음
        //     왼쪽 오른쪽 번갈아가면서 확인 해야 함.

        /*int 왼쪽 = 0;
        for (int i = 0; i < height.length - 1; i++) {
            int 현재 = height[i];
            int 오른쪽 = height[i + 1];

            if (왼쪽 <= 현재 &&  현재 <= 오른쪽) {
                continue;
            }
            if (왼쪽 > 현재 && 현재 < 오른쪽) {
                trap += Math.min(왼쪽, 오른쪽);
            }
            if (왼쪽 > 현재 && 현재 > 오른쪽) {
                // 오른쪽에서 가장 높은 높이를 찾아야함
                int subTrap = 왼쪽 - 현재;
                for (int j = i + 1; j < height.length; j++) {
                    int 새로운오른쪽 = height[j];
                    if (새로운오른쪽 >= 왼쪽) {
                        i = j;
                        break;
                    }
                    subTrap += 왼쪽 - 새로운오른쪽;
                }
                trap += subTrap;
            }
            왼쪽 = height[i];
            System.out.println(i + ":" + trap);
        }*/

        /*
        접근은 좋았지만 중간 로직이 틀림.
        int 왼쪽포인터 = 0;
        int 오른쪽포인터 = height.length - 1;

        int 왼쪽 = 0;
        int 오른쪽 = 0;
        boolean 방향 = true; // true -> 왼쪽, false -> 오른
        while (왼쪽포인터 < 오른쪽포인터) {
            if (방향) {
                int 현재 = height[왼쪽포인터];
                int 현재오른쪽 = height[왼쪽포인터 + 1];

                System.out.println(String.format("왼쪽 탐색 : %d:%d:%d:%d", 왼쪽, 현재, 현재오른쪽, trap));

                if (왼쪽 <= 현재 && 현재 <= 현재오른쪽) {
                    왼쪽 = height[왼쪽포인터++];
                    continue;
                }
                if (왼쪽 > 현재 && 현재 < 현재오른쪽) {
                    trap += Math.min(왼쪽, 현재오른쪽) - 현재;
                }
                if (왼쪽 > 현재 && 현재 > 현재오른쪽) {
                    // 오른쪽에서 가장 높은 높이를 찾아야함
                    int subTrap = 왼쪽 - 현재;
                    for (int j = 왼쪽포인터 + 1; j < 오른쪽포인터; j++) {
                        int 새로운오른쪽 = height[j];
                        if (새로운오른쪽 >= 왼쪽) {
                            break;
                        }
                        왼쪽포인터 = j;
                        subTrap += 왼쪽 - 새로운오른쪽;
                    }
                    System.out.println(String.format("왼쪽탐색 더하기 : %d, %d", trap, subTrap));
                    trap += subTrap;
                    방향 = false;
                }
                왼쪽 = height[왼쪽포인터++];
            } else {
                int 현재왼쪽 = height[오른쪽포인터 - 1];
                int 현재 = height[오른쪽포인터];

                System.out.println(String.format("오른쪽 탐색 : %d:%d:%d:%d", 현재왼쪽, 현재, 오른쪽, trap));

                if (현재왼쪽 >= 현재 && 현재 >= 오른쪽) {
                    오른쪽 = height[오른쪽포인터--];
                    continue;
                }
                if (현재왼쪽 > 현재 && 현재 < 오른쪽) {
                    trap += Math.min(현재왼쪽, 오른쪽) - 현재;
                }
                if (현재왼쪽 < 현재 && 현재 < 오른쪽) {
                    // 왼쪽에서 가장 높은 높이를 찾아야함
                    int subTrap = 오른쪽 - 현재;
                    for (int j = 오른쪽포인터 - 1; j >= 왼쪽포인터; j--) {
                        int 새로운왼쪽 = height[j];
                        System.out.println("j" + j);
                        if (새로운왼쪽 >= 오른쪽) {
                            break;
                        }
                        오른쪽포인터 = j;
                        subTrap += 오른쪽 - 새로운왼쪽;
                    }
                    System.out.println(String.format("오른쪽탐색 더하기 : %d, %d", trap, subTrap));
                    trap += subTrap;

                    방향 = true;
                }
                오른쪽 = height[오른쪽포인터--];
            }
            // System.out.println("왼쪽:" + 왼쪽포인터 + ",오른쪽:" + 오른쪽포인터 + ",trap:" + trap);
        }*/

        // System.out.println(trap);

        int water = 0;

        int leftIndex = 0;
        int rightIndex = height.length - 1;

        // 물을 잡아 놓을수 있는 최초의 위치 찾기
        while (leftIndex < rightIndex && height[leftIndex] <= height[leftIndex + 1]) {
            leftIndex ++;
        }
        while (leftIndex < rightIndex && height[rightIndex] <= height[rightIndex - 1]) {
            rightIndex --;
        }

        /*
         |
         |              x
         |      x = = = x x = x
         |__x_=_x_x_=_x_x_x_x_x_x_
          0 1 2 3 4 5 6 7 8 9 1011

         height = [0,1,0,2,1,0,1,3,2,1,2,1];

         높은 기둥에서 낮은 기둥으로는 정확하게 물 양을 계산 가능
         낮은 기둥에서 높은 기둥으로는 계산이 부정확해짐

         양쪽의 물을 담을수 있는 최소한의 위치를 찾은 다음에
         높은 기둥을 기준으로 낮은 쪽으로 간다는 생각으로 왼쪽 <-> 오른쪽 방향으로 찾아 나가기
         */

        // 양쪽으로 왔다 갔다 하면서 물 담기
        while (leftIndex < rightIndex) {
            int left = height[leftIndex];
            int right = height[rightIndex];

            if (left <= right) {
                // 물을 채워 넣음
                while (leftIndex < rightIndex && left >= height[++leftIndex]) {
                    water += left - height[leftIndex];
                }
            } else {
                while (leftIndex < rightIndex && height[--rightIndex] <= right) {
                    water += right - height[rightIndex];
                }
            }
        }

        return water;
    }

    public static void main(String[] args) {
        Solution0801 s = new Solution0801();
        int[] height = new int[]{2,34,4,23,65,3,8,1,2,0};

        System.out.println("result : " + s.trap(height));
/*
        height = new int[]{4,2,0,3,2,5};

        if (9 != s.trap(height)) throw new AssertionError();*/


        // [2,34,4,23,65,3,8,1,2,0]
        /*

        65     X
        34  X  X
        23  X XX
        8   X XX X
        4   XXXX X
        3   XXXXXX
        2  XXXXXXX X
        1  XXXXXXXXX
        0  XXXXXXXXXX
        */

    }
}
