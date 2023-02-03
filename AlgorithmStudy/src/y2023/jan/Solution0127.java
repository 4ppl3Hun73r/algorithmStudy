package y2023.jan;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/concatenated-words/
public class Solution0127 {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {

        Set<String> cache = new HashSet<>();
        for (String word : words) {
            cache.add(word);
        }

        List<String> result = new ArrayList<>();

        for (String s : cache) {
            boolean[] visited = new boolean[s.length()];
            if (dfs(s, 0, visited, cache)) {
                result.add(s);
            }
        }

        return result;
    }

    private boolean dfs(String s, int idx, boolean[] visited, Set<String> cache) {
        if (s.length() == idx) {
            return true;
        }
        if (visited[idx]) {
            return false;
        }

        for (int i = s.length() - (idx == 0 ? 1 : 0); i > idx; i--) {
            String substr = s.substring(idx, i);
            System.out.println(s + " : " + substr);
            if (cache.contains(substr) && dfs(s, i, visited, cache)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) throws Exception {
        Solution0127 s = new Solution0127();

        System.out.println(s.findAllConcatenatedWordsInADict(
                new String[]{"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"}
        ));
    }
}
