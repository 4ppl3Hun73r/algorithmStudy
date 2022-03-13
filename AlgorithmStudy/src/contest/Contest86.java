package contest;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Contest86 {

    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {

        Set<int[]>[] artifactSet = new Set[artifacts.length];

        Comparator<int[]> comparator = Comparator.comparingInt(o -> o[0]);
        comparator = comparator.thenComparingInt(o -> o[1]);

        TreeMap<int[], Integer> posArtifactCntMap = new TreeMap<>(comparator);

        for (int i = 0; i < artifacts.length; i++) {
            artifactSet[i] = new TreeSet<>(comparator);

            int[] artifact = artifacts[i];
            int startRow = artifact[0];
            int endRow = artifact[2];
            int startCol = artifact[1];
            int endCol = artifact[2];
            for (int j = startRow; j <= endRow; j++) {
                for (int k = startCol; k <= endCol ; k++) {
                    int[] key = new int[]{j,k};
                    posArtifactCntMap.put(key, posArtifactCntMap.getOrDefault(key, 0) + 1);
                    artifactSet[i].add(key);
                }
            }
        }


        for (int[] d : dig) {
            for (int i = 0; i < n; i++) {
                if (artifactSet[i].size() > 0) {
                    artifactSet[i].remove(d);
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (artifactSet[i].size() == 0) {
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Contest86 c = new Contest86();

    }
}
