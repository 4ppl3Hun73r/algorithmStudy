package contest;

public class Contest94 {
    public String minimizeResult(String expression) {

        /*
         A + B

         로 들어올떄
         a1 ( a2 + b1 )  b2 으로 만들수있다. 이때 가장 작은 값을 가진 expression 을 반환


         3 < expression 길이 10

         1 + 1
         */

        String[] split = expression.split("\\+");
        String a = split[0];
        String b = split[1];

        int min = Integer.MAX_VALUE;
        String ans = expression;
        for (int i = 0; i < a.length(); i++) {
            String a1 = a.substring(0, i);
            String a2 = a.substring(i);
            int a1Num = 1;
            if (a1.length() != 0) {
                a1Num = Integer.parseInt(a1, 10);
            }
            int a2Num = Integer.parseInt(a2, 10);

            for (int j = 0; j < b.length(); j++) {
                String b1 = b.substring(0, j + 1);
                String b2 = b.substring(j + 1);
                int b1Num = Integer.parseInt(b1, 10);
                int b2Num = 1;
                if (b2.length() != 0) {
                    b2Num = Integer.parseInt(b2, 10);;
                }

                int m = a1Num * (a2Num + b1Num) * b2Num;
                if (m < min) {
                    ans = a1 + "(" + a2 + "+" + b1 + ")" + b2;
                    min = m;
                }
            }
        }

        return ans;
    }


    public static void main(String[] args) {
        Contest94 c = new Contest94();

        System.out.println(c.minimizeResult("999+999"));
        System.out.println(c.minimizeResult("12+34"));


    }
}
