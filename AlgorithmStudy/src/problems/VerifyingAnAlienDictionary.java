package problems;

public class VerifyingAnAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        /*
        알파벳 순서를 order로 변경함
        words가 해당 순서로 정렬 되었는지 확인
         */
        int[] map = new int[26];
        for (int i = 0; i < order.length(); i++){
            map[order.charAt(i) - 'a'] = i;
        }

        for (int i = 1; i < words.length; i++) {
            // w1이 w2보다 작아야함
            if (compare(words[i - 1], words[i], map)) {
                return false;
            }
        }

        return true;
    }

    private boolean compare(String w1, String w2, int[] map) {
        int len1 = w1.length();
        int len2 = w2.length();
        for (int j = 0; j < len1 && j < len2; j++) {
            if (w1.charAt(j) != w2.charAt(j)) {
                return map[w1.charAt(j) - 'a'] > map[w2.charAt(j) - 'a'];
            }
        }
        return len1 > len2;
    }

    public static void main(String[] args) throws Exception {
        VerifyingAnAlienDictionary v = new VerifyingAnAlienDictionary();

        System.out.println(v.isAlienSorted(new String[]{"kuvp","q"},"ngxlkthsjuoqcpavbfdermiywz"));
    }
}
