package contest;

public class Contest37 {

    public String[] divideString(String s, int k, char fill) {
        int divSize = (int)Math.ceil((double)s.length() / (double)k);
        String[] result = new String[divSize];


        int idx = 0;
        int start = 0;
        for (int i = 0; i < divSize; i++) {
            int end = start + k;
            if (end > s.length()) {
                end = s.length();
            }
            result[idx++] = s.substring(start, end);
            start = end;
        }

        idx--;
        if (result[idx].length() != k) {
            StringBuilder sb = new StringBuilder();
            sb.append(result[idx]);

            for (int i = 0; i < k - result[idx].length(); i++) {
                sb.append(fill);
            }

            result[idx] = sb.toString();
        }

        return result;
    }

    public static void main(String[] args) {
        Contest37 c = new Contest37();
    }
}
