package contest;

public class Contest19 {
    public boolean canBeValid(String s, String locked) {
        /*
        () valid
        ((())) valid
        (()()) valid
        )) not valid

        locked -> 0101010 -> 1 은 변경 불가
         */

        // 변경 불가 지점을 기준으로 왼쪽 or 오른쪽을 변경하룻 있는지 확인
        int len = s.length();
        if (len % 2 == 1) return false;


        int openCnt = 0;
        int wildCnt = 0;
        for (int i = 0; i < len; i++) {
            if (locked.charAt(i) == '1') {
                if (s.charAt(i) == '(') {
                    openCnt++;
                } else {
                    openCnt--;
                }
            } else {
                wildCnt++;
            }

            if (openCnt < 0) {
                wildCnt --;
                openCnt = 0;
            }

            if (wildCnt < 0) {
                break;
            }
        }

        if (openCnt > wildCnt) {
            return false;
        }

        int closeCnt = 0;
        wildCnt = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (locked.charAt(i) == '1') {
                if (s.charAt(i) == ')') {
                    closeCnt++;
                } else {
                    closeCnt--;
                }
            } else {
                wildCnt++;
            }

            if (closeCnt < 0) {
                wildCnt --;
                closeCnt = 0;
            }

            if (wildCnt < 0) {
                break;
            }
        }

        return closeCnt <= wildCnt;
    }

    public static void main(String[] args) {
        Contest19 c = new Contest19();

        System.out.println(c.canBeValid(")(", "11"));

        //System.out.println(c.canBeValid("()))(()(()()()()(((())())((()((())", "1100000000000010000100001000001101")); //true

        //System.out.println(c.canBeValid("(()())", "111111"));
        //System.out.println(c.canBeValid("(()()())", "11101111"));

        //System.out.println(c.canBeValid("())(()(()(())()())(())((())(()())((())))))(((((((())(()))))(", "100011110110011011010111100111011101111110000101001101001111"));
        //System.out.println(c.canBeValid("())(()(()(())()())(())((())(()())((())))))(((((((())(())))))", "100011110110011011010111100111011101111110000101001101001111"));
                                         // 100011110110011011010111100111011101111110000101001101001111
        System.out.println(c.canBeValid("))))(())((()))))((()((((((())())((()))((((())()()))(()", "101100101111110000000101000101001010110001110000000101"));

        //System.out.println(c.canBeValid("())()))()(()(((())(()()))))((((()())(())", "1011101100010001001011000000110010100101"));


        // ()))(()(()()()()(((())())((()((())
        // 1100000000000010000100001000001101


    }
}
