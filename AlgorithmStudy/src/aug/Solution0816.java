package aug;

import java.util.HashMap;
import java.util.Map;

public class Solution0816 {
    public String minWindow(String s, String t) {
        if(s == null || s.length() < t.length() || s.length() == 0) {
            return "";
        }
        Map<Character,Integer> map = new HashMap<>();
        for(char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int minLeft = 0;
        int minLen = s.length()+1;
        int count = 0;
        int tLen = t.length();
        for(int right = 0, left = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if(map.containsKey(c)){
                int subCnt = map.get(c);
                subCnt --;
                map.put(c, subCnt);
                if(subCnt >= 0){
                    count ++;
                }
                while(count == tLen){
                    if(right - left + 1 < minLen){
                        minLeft = left;
                        minLen = right - left + 1;
                    }
                    if(map.containsKey(s.charAt(left))){
                        char c2 = s.charAt(left);
                        int leftCnt = map.get(c2);
                        leftCnt++;
                        map.put(c2, leftCnt);
                        if(leftCnt > 0){
                            count --;
                        }
                    }
                    left ++ ;
                }
            }
        }
        if(minLen>s.length()) {
            return "";
        }

        return s.substring(minLeft, minLeft + minLen);
    }

    public static void main(String[] args) {

        Solution0816 s = new Solution0816();

        System.out.println(s.minWindow("ADOBECODEBANC", "ABC"));
        //System.out.println(s.minWindow("a", "a"));
        //System.out.println(s.minWindow("a", "aa"));
    }
}
