package contest;

public class Contest25 {

    public boolean checkString(String s) {

        boolean checkB = s.charAt(0) == 'b';
        for (int i = 0; i < s.length(); i++) {
            char ab = s.charAt(i);
            if(ab == 'a' && checkB) {
                return false;
            } else if (ab == 'b'){
                checkB = true;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Contest25 c = new Contest25();

        System.out.println(c.checkString("aaabbb"));
        System.out.println(c.checkString("ababab"));
        System.out.println(c.checkString("bbb"));
        System.out.println(c.checkString("bbbaaa"));
        System.out.println(c.checkString("aaaaaa"));
    }
}
