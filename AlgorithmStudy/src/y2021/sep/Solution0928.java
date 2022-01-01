package y2021.sep;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/639/week-4-september-22nd-september-28th/3989/
public class Solution0928 {
    public int numUniqueEmails(String[] emails) {
        // 이메일 규칙
        //  . 은 없다고 보면됨. jiho.sung == jihosung
        //  + 는 + 뒤에는 무시함 jiho.sung+naver == jiho.sung+wev == jihosung
        Set<String> emailSet = new HashSet<>();

        for (String email : emails) {
            String[] s = email.split("@");
            s[0] = s[0].replaceAll("\\.", "").split("\\+")[0];

            emailSet.add(s[0] + "@" + s[1]);
        }/*

        for (String email : emails) {
            //String[] arr = email.split("@");
            //String local = arr[0];
            //String domain = arr[1];
            StringBuilder builder = new StringBuilder();
            int atIndex = -1;
            int plusIndex = -1;
            for (int i = 0; i < email.length(); i++) {
                char c = email.charAt(i);
                if (c == '+') {
                    plusIndex = i;
                    continue;
                }

                if (c == '@') {
                    atIndex = i;
                    break;
                }

                if (plusIndex < 0 && c != '.') {
                    builder.append(c);
                }
            }

            uniqueEmails.add(builder + "@" + email.substring(atIndex));
        }*/

        return emailSet.size();
    }

    private int computeHash(String email){
        // DJBHash
        int hash = 5381; // will have less collisions

        // read untill @ or + which ever comes first
        for(int i=0; i< email.length(); i++){
            char ch = email.charAt(i);
            if( ch == '.') continue;
            else if(ch != '@' && ch != '+')
                hash = (hash << 5) + hash + ch; // hash * 33 + ch
            else
                break;
        }

        // read untill @
        for(int i= email.length()-1; i>=0; i--){
            char ch = email.charAt(i);
            if(ch != '@'){
                hash = (hash << 5) + hash + ch; // hash * 33 + ch
            }
            else
                break;
        }

        return hash;
    }
}
