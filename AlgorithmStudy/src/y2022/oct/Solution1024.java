package y2022.oct;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/
public class Solution1024 {
    public int maxLength(List<String> arr) {
        //un, iq, ue
        // un, iq, ue, uniq, unue, ique, unique
        // 3 * 2 * 1
        // 16 * 15 ~ 1
        /*
        // 최대길이 26
            -> alphabet map -> 시키거나, 아니면 bit 로 바꾼다음에 and 했을떄 0이 아니면 중복이 있는거 그러면 그 경우에서수는 패스

         */
        List<Integer> bitMap = new ArrayList<>();
        for (String s : arr) {
            int bit = 0;
            boolean add = true;
            for (char c : s.toCharArray()) {
                int idx = c - 'a';
                // 만약에 uniu -> 이거는 걸르고 싶은데
                if ((bit & (1<<idx)) != 0) {
                    add = false;
                    break;
                }
                bit |= 1<<idx;
            }
            if (add) {
                bitMap.add(bit);
            }
        }
        /*for (Integer integer : bitMap) {
            System.out.print(Integer.toBinaryString(integer) + ",");
        }
        System.out.println();*/

        return backTracking(bitMap, 0, 0);
    }

    private int backTracking(List<Integer> list, int index, int currStr) {
        if (index == list.size()) {
            // currStr 안에 있는 1의 수
            return Integer.bitCount(currStr);
        }

        int len = 0;
        for (int i = index; i < list.size(); i++) {
            int cur = list.get(i);
            if ((cur & currStr) > 0) {
                len = Math.max(len, Integer.bitCount(currStr));
                continue;
            }
            len = Math.max(len, backTracking(list, i + 1, currStr | cur));
        }

        return len;
    }


    public static void main(String[] args) throws Exception {
        Solution1024 s = new Solution1024();

        System.out.println(s.maxLength(List.of("un","iq","ueu")));
        System.out.println(s.maxLength(List.of("cha","r","act","ers")));
        System.out.println(s.maxLength(List.of("abcdefghijklmnopqrstuvwxyz")));

    }
}
