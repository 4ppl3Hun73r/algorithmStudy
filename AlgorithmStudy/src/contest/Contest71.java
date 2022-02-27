package contest;

public class Contest71 {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        char lastAppend = ' ';
        int cntRepeat = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 25; j >= 0; j--) {
                if (map[j] != 0) {
                    char appendChar = (char)('a' + j);
                    if (appendChar == lastAppend) {
                        cntRepeat++;
                        if (cntRepeat >= repeatLimit) {
                            continue;
                        }
                    } else {
                        cntRepeat = 0;
                    }
                    map[j]--;
                    sb.append(appendChar);
                    lastAppend = appendChar;
                    break;
                }
            }
        }


        return sb.toString();
    }

    public static void main(String[] args) {
        Contest71 c = new Contest71();

    }
}
