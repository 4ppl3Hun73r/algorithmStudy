package y2021.aug;

import java.util.*;
import java.util.stream.Collectors;

// https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/614/week-2-august-8th-august-14th/3887/
public class Solution0813 {

    public List<List<String>> groupAnagrams1(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) count[c - 'a']++;

            // "abc" => "#1#1#1#0#0#0#0#0#0#0....";
            // "cab" -> "#1#1#1#0#0#0#0#0#0#0....";
            // '1110000'
            // '1101100'

            // O(N*K)
            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }

    private static final int[] PRIMES = new int[]{2, 3, 5, 7, 11 ,13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 107};
    public List<String> anagrams(String[] strs) {
        List<String> list = new LinkedList<>();
        // O(N * K)
        Map<Integer, List<String>> mapString = new HashMap<>();
        int result = -1;
        for (int i = 0; i < strs.length; i++){
            int mapping = 1;
            for (int j = 0, max = strs[i].length(); j < max; j++) {
                // prime * prime * prime => 증명 가능하겠죠?????
                // 'a'-> 1 ... 'z' -> 23
                // azb -> 1* 22 * 2 = 46 / 2 * 2 * 11
                // ayb == bbt
                // sort -> // sort 비용이 '0' - '0';
                // sort가 없으니까 빠른거죠. O(N)
                mapping *= PRIMES[strs[i].charAt(j) - 'a'];
            }
            List<String> strings = mapString.get(mapping);
            if (strings == null) {
                strings = new LinkedList<>();
                mapString.put(mapping, strings);
            }
            strings.add(strs[i]);
        }
        for (List<String> mapList : mapString.values()){
            if (mapList.size() > 1)
                list.addAll(mapList);
        }
        return list;
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        // 정환
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            List<String> list = map.getOrDefault(sorted, new ArrayList<>(1));
            list.add(str);
            map.put(sorted, list);
        }

        return map.values().stream().collect(Collectors.toList());
    }

    public List<List<String>> groupAnagrams3(String[] strs) {
        //윤미

        Map<String, List<String>> resultMap = new HashMap<>();

        for (String original : strs) {
            char[] charArr = original.toCharArray();
            Arrays.sort(charArr);
            String sorted = new String(charArr);
            if (!resultMap.containsKey(sorted))
                resultMap.put(sorted, new ArrayList<>());
            resultMap.get(sorted).add(original);
        }
        return resultMap.keySet()
                .stream().map(resultMap::get)
                .collect(Collectors.toList());

    }

    public List<List<String>> groupAnagrams4(String[] strs) {
        // 지호
        /*
        let o = {};
        for (let i = 0; i < strs.length; i++) {
            let str = strs[i];
            let reorder = str.split("").sort().join("");

            if (o[reorder] === undefined) o[reorder] = [];
            o[reorder].push(str);
        }

        let ret = [];
        for (let i in o) {
            ret.push(o[i]);
        }

        return ret;
         */
        return null;
    }

}
