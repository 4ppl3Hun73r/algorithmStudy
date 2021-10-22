package problems;

public class BackspaceStringCompare {
    public boolean backspaceCompare(String s, String t) {
        int sPos = s.length() - 1;
        int tPos = t.length() - 1;

        int sBackspace = 0;
        int tBackspace = 0;
        while (sPos >= 0 || tPos >= 0) {

            while (sPos >= 0) {
                if (s.charAt(sPos) == '#') {
                    sBackspace ++;
                    sPos --;
                } else if (sBackspace > 0) {
                    sBackspace --;
                    sPos --;
                } else {
                    break;
                }
            }

            while (tPos >= 0) {
                if (t.charAt(tPos) == '#') {
                    tBackspace ++;
                    tPos --;
                } else if (tBackspace > 0) {
                    tBackspace --;
                    tPos --;
                } else {
                    break;
                }
            }

            if (sPos >= 0 && tPos >= 0 && s.charAt(sPos) != t.charAt(tPos)) {
                return false;
            }

            //
            if ((sPos >= 0) != (tPos >= 0))
                return false;

            sPos --;
            tPos --;
        }

        return true;
    }

    public static void main(String[] args) {
        BackspaceStringCompare b = new BackspaceStringCompare();
        /*System.out.println(b.backspaceCompare("ab#c", "#a#c"));
        System.out.println(b.backspaceCompare("ab##", "c#d#"));
        System.out.println(b.backspaceCompare("a##c", "#a#c"));*/
        //System.out.println(b.backspaceCompare("a#c", "b"));
        //System.out.println(b.backspaceCompare("bxj##tw", "bxo#j##tw"));
        System.out.println(b.backspaceCompare("bxj##tw", "bxj###tw"));

    }
}
