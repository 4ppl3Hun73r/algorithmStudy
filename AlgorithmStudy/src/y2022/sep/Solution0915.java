package y2022.sep;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/find-original-array-from-doubled-array/
public class Solution0915 {
    public int[] findOriginalArray(int[] changed) {
        /*
        original 의 모든 배열의 값에 *2 를 한게 changed 배열

        original 배열 을 반환하라

        만약 changed 에 original 이 없다면 [] 를 반환

        [1,3,4,2,6,8]
         */
        if (changed.length % 2 == 1) {
            return new int[0];
        }

        Map<Integer, Integer> numCntMap = new HashMap<>();
        for (int i : changed) {
            numCntMap.put(i, numCntMap.getOrDefault(i, 0) + 1);
        }

        int[] ans = new int[changed.length / 2];
        int idx = 0;
        Arrays.sort(changed);
        for (Integer key : changed) {
            int doubleVal = key * 2;

            int originCnt = numCntMap.getOrDefault(key, 0);
            if (originCnt == 0) {
                continue;
            }
            int doubleCnt = numCntMap.getOrDefault(doubleVal, 0);

            if (originCnt > doubleCnt) {
                return new int[0];
            }
            if (key == 0) {
                for (int i = 0; i < originCnt / 2; i++) {
                    ans[idx++] = key;
                }
            } else {
                for (int i = 0; i < originCnt; i++) {
                    ans[idx++] = key;
                }
            }

            numCntMap.put(key, 0);
            numCntMap.put(doubleVal, doubleCnt - originCnt);

            //
            //[1,3,4,2,6,8]
            // 1,2,2,3,4,4,6,8
            /*
            1 - 1
            2 - 2 - 1 1
            4 - 2
             */
        }

        return ans;
    }

    // A   execute()
    // B string, C - Map
    // opf <page, 정보>
    //     <image, xhtml주소>
    // xhtml , src -> string
    //     <xhtml, string>
    /*
    mag.get(page) == null -> 추가 조회
    ret.getPage() == null -> 추가 조회
            interface Inf {
                getSrc();
                getPage(); -> null
            ....
            }
            class BImpl implements Inf;
             root refe;
             getPage() -> null 이 안나오게 추가로직을
            class CImpl implements Inf;
            Inf methodA(root);
           <xhtml, string>

           void execute(R);
           void page(R)
           void xhtml(R);

           .....

           R -> 무조건 완성되어 있다. 보장 하는 느낌으로
     */
    /* page, { image src, pageLR
//
    } */

    public int[] findOriginalArrayp(int[] changed) {
        if(changed.length%2 != 0) return new int[0];
        int max = Integer.MIN_VALUE;
        for(int num : changed) max = Math.max(max, num);
        if(max%2 != 0) return new int[0];

        int[] cnts = new int[max+1];
        for(int num : changed) cnts[num]++;

        int[] res = new int[changed.length/2];
        if(cnts[0] % 2 != 0) return new int[0];
        int idx = cnts[0]/2;
        for(int i = 1; i < cnts.length; i++) {
            if(cnts[i] == 0) continue;
            if(2*i > max || cnts[i] > cnts[2*i]) return new int[0];
            int cnt = cnts[i];
            cnts[2*i] -= cnt;
            while(cnt-- > 0) res[idx++] = i;
        }

        return res;
    }

    private Object method() {
        int n = 0;
        if ( n == 0) {
            return new int[0];
        }
        return new double[0];
    }

    public static void main(String[] args) throws Exception {
        Solution0915 s = new Solution0915();

        System.out.println(Arrays.toString(s.findOriginalArray(new int[]{2, 1, 2, 4, 2, 4})));
    }
}
