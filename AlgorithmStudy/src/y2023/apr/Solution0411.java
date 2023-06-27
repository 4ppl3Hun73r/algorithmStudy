package y2023.apr;

// https://leetcode.com/problems/removing-stars-from-a-string/
public class Solution0411 {
    public String removeStars(String s) {
        /*
        s -> *이 포함되어 있음
        *을 선택해서 왼쪽에 있는 가까운 *이 아닌 문자를 *과 함께 지움.
        모든 *이 제거된 문자를 만들기
         */

        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '*') {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(c);
            }
        }
        // oracle -> md 당 돈을 추가로 받는다., si develop -> free
        // reactive -> Postgres
        // db level blocking

        return sb.toString();
    }
}
