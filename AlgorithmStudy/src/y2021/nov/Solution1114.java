package y2021.nov;

import java.util.ArrayList;
import java.util.List;

public class Solution1114 {
    public static void main(String[] args) {
        CombinationIterator c = new CombinationIterator("abc", 3);

        System.out.println(c.next());
        System.out.println(c.hasNext());
        }
}

class CombinationIterator {
    List<String> preCombination;
    char[] chars;

    public CombinationIterator(String characters, int combinationLength) {
        chars = characters.toCharArray();
        preCombination = new ArrayList<>();

        // 3, 0, 1 => 3 - 2
        char[] sb = new char[combinationLength];
        for (int i = 0; i <= chars.length - combinationLength; i++) {
            sb[0] = chars[i];
            combination(i + 1, chars.length, combinationLength - 1, sb, 1);
        }
    }

    private void combination(int start, int end, int len, char[] sb, int depth) {
        if (len == 0) {
            preCombination.add(new String(sb));
            return ;
        }

        for (int i = start; i < end; i++) {
            sb[depth] = chars[i];
            combination(i + 1, end, len - 1, sb, depth + 1);
        }
    }

    public String next() {
        return preCombination.remove(0);

    }

    public boolean hasNext() {
        return !(preCombination.size() == 0);
    }
}