package contest;

import java.util.HashSet;
import java.util.Set;

public class Contest28 {
    public int maximumInvitations(int[] favorite) {
        Set<Integer>[] map = new Set[favorite.length];

        for (int i = 0; i < favorite.length; i++) {
            map[i] = new HashSet<>();
        }
        for (int i = 0; i < favorite.length; i++) {
            map[favorite[i]].add(i);
            map[i].add(favorite[i]);
        }

        // 각 노드의 연결 수가 2가 될때까지 루프
        boolean check = true;
        while (check) {
            check = false;
            for (int i = 0; i < favorite.length; i++) {
                if (map[i].size() > 2) {
                    check = true;
                    int cadi = -1;
                    for (Integer fav : map[i]) {
                        if (map[fav].size() == 1) {
                            cadi = fav;
                            break;
                        } else if (map[fav].size() > 2) {
                            cadi = fav;
                            break;
                        }
                    }
                    if (cadi > -1) {
                        map[i].remove(cadi);
                        map[cadi].remove(i);
                    }
                }
            }
        }

        int result = 0;
        for (int i = 0; i < favorite.length; i++) {
            if (map[i].size() > 0) result ++;
        }
        return result;
    }

    public static void main(String[] args) {
        Contest28 c = new Contest28();

        System.out.println(c.maximumInvitations(new int[] {1,2,3,4,2,1,2,3,1,0,5,0}));
    }
}
