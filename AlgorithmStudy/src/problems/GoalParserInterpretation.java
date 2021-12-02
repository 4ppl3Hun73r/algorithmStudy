package problems;

// https://leetcode.com/problems/goal-parser-interpretation/
public class GoalParserInterpretation {
    public String interpret(String command) {
        StringBuilder sb = new StringBuilder();

        char[] arr = command.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (c == 'G') {
                sb.append(c);
            } else if (c == '(' && arr[i + 1] == ')') {
                sb.append('o');
                i++;
            } else {
                sb.append('a').append('l');
                i += 3;
            }
        }

        return sb.toString();
    }
}
