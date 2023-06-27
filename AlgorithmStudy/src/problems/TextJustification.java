package problems;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/text-justification/
public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        // TODO 제출전
        List<String> result = new ArrayList<>();

        StringBuilder sb = new StringBuilder(maxWidth);
        for (String word : words) {
            int currentWidth = sb.length();
            int wordWidth = word.length();

            if (currentWidth + wordWidth <= maxWidth) {
                sb.append(word);
            } else {
                sb.append(" ".repeat(Math.max(0, maxWidth - (currentWidth + wordWidth))));
                result.add(sb.toString());
                sb.delete(0, maxWidth);
                sb.append(word);
            }
        }
        
        if (sb.length() != 0) {
            result.add(sb.toString());
        }

        return result;
    }
    
    public static void main(String[] args) throws Exception {
        TextJustification s = new TextJustification();



        System.out.println(s.fullJustify(new String[]{"What","must","be","acknowledgment","shall","be"}, 16));
    }
}
