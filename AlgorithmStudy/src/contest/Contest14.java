package contest;

public class Contest14 {
    public String addSpaces(String s, int[] spaces) {

        StringBuilder sb = new StringBuilder();

        int c = 0;
        for (int i = 0; i < s.length(); i++) {
            if (c < spaces.length && i == spaces[c]) {
                c ++;
                sb.append(' ');
            }
            sb.append(s.charAt(i));
        }

        return sb.toString();

    }

    public static void main(String[] args) {
        Contest14 c = new Contest14();
        for (int i = 0; i < 300000; i++) {
            System.out.print('a');
        }
    }
}
