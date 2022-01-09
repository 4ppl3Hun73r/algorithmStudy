package contest;

import java.util.HashSet;
import java.util.Set;

public class Contest33 {

    public boolean checkValid(int[][] matrix) {

        Set<Integer> checkSet = new HashSet<>();
        int n = matrix.length;

        for (int i = 1; i <= n; i++) {
            checkSet.add(i);
        }

        for (int i = 0; i < n; i++) {
            Set<Integer> dupSet = new HashSet<>(checkSet);
            for (int j = 0; j < n; j++) {
                if (dupSet.contains(matrix[i][j])) {
                    dupSet.remove(matrix[i][j]);
                } else {
                    return false;
                }
            }
            if (!dupSet.isEmpty()) {
                return false;
            }
        }

        for (int i = 0; i < n; i++) {
            Set<Integer> dupSet = new HashSet<>(checkSet);
            for (int j = 0; j < n; j++) {
                if (dupSet.contains(matrix[j][i])) {
                    dupSet.remove(matrix[j][i]);
                } else {
                    return false;
                }
            }
            if (!dupSet.isEmpty()) {
                return false;
            }
        }


        return true;

    }

    public static void main(String[] args) {
        Contest33 c = new Contest33();
    }
}
