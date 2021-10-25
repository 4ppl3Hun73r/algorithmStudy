package oct;

// https://leetcode.com/problems/reverse-words-in-a-string/
public class Solution1020 {
    public String reverseWords2(String s) {

        String[] arr = s.split("\\s");
        StringBuffer sb = new StringBuffer();
        for (int i = arr.length - 1; i >= 0; i--) {
            // arr[i] = ' ';
            String trim = arr[i].trim();
            if (trim.length() == 0) continue;
            sb.append(trim);
            if (i != 0) {
                sb.append(' ');
            }
        }

        return sb.toString().trim();
    }

    public String reverseWords(String s) {
        // Two Point
        char[] arr = s.toCharArray();
        int wordLen = 0;
        StringBuffer sb = new StringBuffer();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == ' ') { // [i+1] != ' '
                if (wordLen != 0) {
                    if (sb.length() != 0) {
                        sb.append(' ');
                    }
                    sb.append(s.substring(i + 1, i + 1 + wordLen));
                }
                wordLen = 0;
            } else {
                wordLen++;
            }
        }
        if (wordLen != 0) {
            if (sb.length() != 0) {
                sb.append(' ');
            }
            sb.append(s.substring(0, wordLen));
        }

        return sb.toString();
    }

    public String reverseWords3(String s) {
        // String[]str = s.trim().split("\\W+");
        // StringBuilder sb = new StringBuilder();
        // for(int i = str.length-1; i>= 0; i--){
        //     sb.append(str[i].trim());
        //     if(i !=0){
        //         sb.append(" ");
        //     }
        // }
        //  return sb.toString();

        char[] ch = s.toCharArray();
        char[] res = new char[ch.length + 1];
        int index = 0;
        for(int i = ch.length - 1; i >= 0; --i) {
            if(ch[i] == ' ') {
                continue;
            }

            int lastIndex = i;
            while(i >= 0 && ch[i] != ' ') {
                --i;
            }

            for(int firstIndex = i + 1; firstIndex <= lastIndex; ++firstIndex) {
                res[index++] = ch[firstIndex];
            }

            res[index++] = ' ';
        }

        return new String(res, 0 , index - 1);
    }

    // https://leetcode.com/problems/reverse-words-in-a-string/discuss/47720/Clean-Java-two-pointers-solution-(no-trim(-)-no-split(-)-no-StringBuilder)
    public static void main(String[] args) throws Exception {
        Solution1020 s = new Solution1020();
        System.out.println("[" + s.reverseWords("the sky is blue") + "]");
        System.out.println("[" + s.reverseWords("  hello world  ") + "]");
        System.out.println("[" + s.reverseWords("a good   example") + "]");
        System.out.println("[" + s.reverseWords("  Bob    Loves  Alice   ") + "]");
        System.out.println("[" + s.reverseWords("Alice does not even like bob") + "]");
        System.out.println("[" + s.reverseWords("Alice") + "]");
    }
}
