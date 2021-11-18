package problems;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();

        // 모든 글자가 한번이상은 포함되게, 가장 많이 쪼개야 함.

        // abcdefg -> a, b, c, d, e, f, g -> 쪼개진 s의 길이 => 1, 1, 1, 1, 1, 1, 1
        /*
        ababcbacadefegdehijhklij
        ababcbaca
        defegde
        hijhklij

        ababcbacadefegde, hijhklij 로도 쪼갤수 있지만 최대한 많이 쪼갠게 아닌어서 답이 아님
         */

        // hash table, two pointers, greedy
        int[] lastPos = new int[26];
        char[] sArr = s.toCharArray();

        for (int i = 0; i < sArr.length; i++) {
            lastPos[sArr[i] - 'a'] = i;
        }

        // 단어의 마지막 지점까지 찾기
        int last = 0;
        int count = 0;
        for (int i = 0; i < sArr.length; i++) {
            // 분절 할수 있는 마지막 지점을 업데이트 해 간다.
            last = Math.max(last, lastPos[sArr[i] - 'a']);
            count++;
            if (last == i) {
                result.add(count);
                count = 0;
            }
        }

        return result;
    }
}
