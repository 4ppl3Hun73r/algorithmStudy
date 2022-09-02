package y2022.aug;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/stamping-the-sequence/
public class Solution0821 {
    public int[] movesToStamp(String stamp, String target) {
        /*
            target 길이의 문자열s에 stamp를 찍는다.

            10 * target.length 안에 s를 target 으로 바꿀수 있다면 stamp 를 찍은 위치를 반환

            못하면 [] 반환

            target -> ***** 로 만들기
         */
        char[] stampCharArr = stamp.toCharArray();
        char[] targetCharArr = target.toCharArray();
        List<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[targetCharArr.length];
        int stars = 0;

        while (stars < targetCharArr.length) {
            boolean doneReplace = false;
            for (int i = 0; i <= targetCharArr.length - stampCharArr.length; i++) {
                if (!visited[i] && canReplace(targetCharArr, i, stampCharArr)) {
                    stars = doReplace(targetCharArr, i, stampCharArr.length, stars);
                    doneReplace = true;
                    visited[i] = true;
                    ans.add(i);
                    if (stars == targetCharArr.length) {
                        break;
                    }
                }
            }

            if (!doneReplace) {
                return new int[0];
            }
        }

        int[] resArray = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            resArray[i] = ans.get(ans.size() - i - 1);
        }
        return resArray;
    }

    private boolean canReplace(char[] targetCharArr, int p, char[] stampCharArr) {
        for (int i = 0; i < stampCharArr.length; i++) {
            if (targetCharArr[i + p] != '*' && targetCharArr[i + p] != stampCharArr[i]) {
                return false;
            }
        }
        return true;
    }

    private int doReplace(char[] targetCharArr, int p, int len, int count) {
        for (int i = 0; i < len; i++) {
            if (targetCharArr[i + p] != '*') {
                targetCharArr[i + p] = '*';
                count++;
            }
        }
        return count;
    }
}
