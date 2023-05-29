package y2023.may;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/dota2-senate/
public class Solution0504 {

    public String predictPartyVictory(String senate) {


        Queue<Character> queue = new LinkedList<>();

        int rCnt = 0;
        int dCnt = 0;
        for (char c : senate.toCharArray()) {
            queue.offer(c);
            if (c == 'R') {
                rCnt ++;
            } else {
                dCnt ++;
            }
        }

        int rBan = 0;
        int dBan = 0;
        while (rCnt > 0 && dCnt > 0 && !queue.isEmpty()) {
            Character curr = queue.poll();
            if (curr == 'R') {
                if (rBan > 0) {
                    rBan--;
                    rCnt--;
                } else {
                    dBan++;
                    queue.offer('R');
                }
            } else {
                if (dBan > 0) {
                    dBan--;
                    dCnt--;
                } else {
                    rBan++;
                    queue.offer('D');
                }
            }
        }

        return rCnt > 0 ? "Radiant" : "Dire";

        // "Radiant" or "Dire".
    }
}
