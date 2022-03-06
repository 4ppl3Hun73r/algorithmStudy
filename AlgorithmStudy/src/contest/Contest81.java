package contest;

import java.util.ArrayList;
import java.util.List;

public class Contest81 {


    public List<String> cellsInRange(String s) {

        List<String> ans = new ArrayList<>();


        String[] split = s.split(":");

        int startRow = split[0].charAt(1) - '0';
        int endRow = split[1].charAt(1) - '0';
        int startCol = split[0].charAt(0);
        int endCol = split[1].charAt(0);

        for (int i = startCol; i <= endCol; i++) {
            for (int j = startRow; j <= endRow; j++) {
                ans.add((char)i + "" + j);
            }
        }

        return ans;

    }


    public static void main(String[] args) {
        Contest81 c = new Contest81();

    }
}
