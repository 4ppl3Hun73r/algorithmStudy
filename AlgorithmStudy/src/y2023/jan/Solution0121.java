package y2023.jan;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/restore-ip-addresses/
public class Solution0121 {

    List<String> result = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {

        String[] ip = new String[4];
        backtracking(s, ip, 0);

        return result;
    }

    void backtracking(String s, String[] ip, int idx) {
        if (idx == 3) {
            if (s.charAt(0) == '0' && s.length() != 1) {
                return;
            }
            try {
                Integer parseInt = Integer.parseInt(s);
                if (parseInt <= 255) {
                    ip[idx] = s;
                    result.add(String.join(".", ip));
                }
            } catch (Exception e) {
                return ;
            }
            return ;
        }

        for (int i = 1; i < Math.min(4, s.length()); i++) {
            if (s.charAt(0) == '0' && i != 1) {
                continue;
            }

            String sub = s.substring(0, i);
            Integer parseInt = Integer.parseInt(sub);
            if (parseInt <= 255) {
                ip[idx] = sub;
                backtracking(s.substring(i), ip, idx + 1);
            }
        }
    }
}
