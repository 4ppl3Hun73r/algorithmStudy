package contest;

public class Contest73 {


    public int prefixCount(String[] words, String pref) {
        int cnt = 0;


        for (String word : words) {
            if (word.startsWith(pref)) {
                cnt++;
            }
        }

        return cnt;

    }

    public static void main(String[] args) {
        Contest73 c = new Contest73();

    }
}
