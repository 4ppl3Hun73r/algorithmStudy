package problems;

public class ToLowerCase {
    public String toLowerCase(String s) {
        int A = 'A';
        int Z = 'Z';

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (A <= c && c <= Z) {
                sb.append((char)('a' + (c - A)));
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
