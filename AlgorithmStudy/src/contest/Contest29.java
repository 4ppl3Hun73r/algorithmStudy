package contest;

// https://leetcode.com/contest/biweekly-contest-69/problems/capitalize-the-title
public class Contest29 {
    public String capitalizeTitle(String title) {

        String[] str = title.split(" ");
        StringBuilder sb = new StringBuilder();

        for (String s : str) {
            char[] chArr = s.toCharArray();
            if (s.length() == 1 || s.length() == 2) {
                for (char c : chArr) {
                    sb.append(Character.toLowerCase(c));
                }
            } else {
                sb.append(Character.toUpperCase(chArr[0]));
                for (int i = 1; i < chArr.length; i++) {
                    sb.append(Character.toLowerCase(chArr[i]));
                }
            }
            sb.append(' ');
        }
        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();

    }

    public static void main(String[] args) {
        Contest29 c = new Contest29();
    }
}
