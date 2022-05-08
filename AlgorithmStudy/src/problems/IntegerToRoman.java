package problems;

import java.util.TreeMap;

public class IntegerToRoman {
    public String intToRoman(int num) {
        /*
        I             1
        V             5
        X             10
        L             50
        C             100
        D             500
        M             1000
        I can be placed before V (5) and X (10) to make 4 and 9.
        X can be placed before L (50) and C (100) to make 40 and 90.
        C can be placed before D (500) and M (1000) to make 400 and 900.

        IV -> 4, IX -> 9
        XL -> 40, XC -> 90
        CD -> 400, CM -> 900
         */
        TreeMap<Integer, String> map = new TreeMap<>((o1, o2) -> o2 - o1);
        map.put(1, "I");
        map.put(2, "II");
        map.put(3, "III");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");

        StringBuilder sb = new StringBuilder();
        for (Integer n : map.keySet()) {
            int a = num / n;
            if ( a > 0 ) {
                String c = map.get(n);
                for (int i = 0; i < a; i++) {
                    sb.append(c);
                }
            }
            num = num % n;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        IntegerToRoman i = new IntegerToRoman();

        //System.out.println(i.intToRoman(58));

        for (int j = 1; j < 3999; j++) {
            System.out.println(j);
            
        }
    }
}
