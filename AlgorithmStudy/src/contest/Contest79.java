package contest;

import java.util.*;

public class Contest79 {

    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> ans = new ArrayList<>();

        Map<Integer, Set<Integer>> ancestorsMap = new HashMap<>();
        Map<Integer, Set<Integer>> childMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            ancestorsMap.put(i, new TreeSet<>());
            childMap.put(i, new TreeSet<>());
        }

        for (int[] edge : edges) { // from -> to
            ancestorsMap.get(edge[1]).add(edge[0]);
            childMap.get(edge[0]).add(edge[1]);
        }


        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (ancestorsMap.get(i).size() == 0) {
                queue.add(i);
            }
        }

        Set<Integer> nextNode = new TreeSet<>();
        while (!queue.isEmpty()) {
            int size = queue.size();

            nextNode.clear();
            for (int i = 0; i < size; i++) {
                int node = queue.poll();

                Set<Integer> childSet = childMap.get(node);
                for (Integer child : childSet) {
                    ancestorsMap.get(child).addAll(ancestorsMap.get(node));
                    nextNode.add(child);
                }
            }

            queue.addAll(nextNode);
        }

        for (int i = 0; i < n; i++) {
            ans.add(new ArrayList<>(ancestorsMap.get(i)));
        }


        return ans;
    }

    // dfs로 하면 시간 초과됨... bfs가 답이다.
    private void dfs(Map<Integer, Set<Integer>> ancestorsMap, Map<Integer, Set<Integer>> childMap, int idx) {
        Set<Integer> childSet = childMap.get(idx);
        for (Integer child : childSet) {
            ancestorsMap.get(child).addAll(ancestorsMap.get(idx));
            dfs(ancestorsMap, childMap, child);
        }
    }

    public static void main(String[] args) {

        Contest79 c = new Contest79();
        System.out.println(
        c.getAncestors(34, new int[][]{{27,12},{27,23},{27,25},{27,4},{27,16},{27,32},{27,8},{27,2},{27,10},{27,22},{27,14},{27,21},{27,31},{27,19},{27,24},{27,30},{27,11},{27,6},{27,9},{27,29},{27,3},{27,7},{27,13},{12,25},{12,4},{12,16},{12,32},{12,17},{12,10},{12,14},{12,21},{12,26},{12,19},{12,5},{12,30},{12,20},{12,18},{12,33},{12,11},{12,1},{12,6},{12,9},{12,3},{12,7},{23,4},{23,0},{23,16},{23,32},{23,17},{23,2},{23,10},{23,22},{23,14},{23,21},{23,26},{23,15},{23,30},{23,18},{23,11},{23,6},{23,9},{23,3},{23,7},{23,13},{25,0},{25,16},{25,32},{25,17},{25,8},{25,22},{25,14},{25,26},{25,24},{25,15},{25,5},{25,30},{25,1},{25,6},{25,3},{25,7},{25,13},{4,0},{4,16},{4,2},{4,22},{4,21},{4,31},{4,24},{4,15},{4,5},{4,30},{4,20},{4,7},{0,16},{0,32},{0,17},{0,8},{0,2},{0,10},{0,21},{0,24},{0,15},{0,5},{0,30},{0,18},{0,11},{0,29},{0,13},{16,32},{16,17},{16,10},{16,22},{16,14},{16,21},{16,31},{16,19},{16,24},{16,15},{16,5},{16,20},{16,18},{16,11},{16,6},{16,29},{16,3},{16,13},{32,17},{32,2},{32,14},{32,21},{32,31},{32,19},{32,24},{32,30},{32,20},{32,18},{32,33},{32,11},{32,1},{32,6},{32,28},{32,29},{32,7},{32,13},{17,8},{17,2},{17,10},{17,21},{17,31},{17,15},{17,5},{17,20},{17,18},{17,33},{17,11},{17,1},{17,6},{17,9},{17,29},{17,3},{17,7},{17,13},{8,22},{8,14},{8,26},{8,15},{8,5},{8,30},{8,20},{8,18},{8,33},{8,1},{8,6},{8,7},{2,22},{2,21},{2,31},{2,19},{2,15},{2,30},{2,20},{2,33},{2,1},{2,6},{2,9},{2,29},{2,3},{10,31},{10,26},{10,19},{10,5},{10,30},{10,20},{10,18},{10,33},{10,11},{10,6},{10,28},{10,29},{10,3},{10,7},{10,13},{22,14},{22,21},{22,31},{22,26},{22,19},{22,24},{22,20},{22,18},{22,33},{22,6},{22,9},{22,3},{22,7},{22,13},{14,21},{14,31},{14,19},{14,15},{14,5},{14,18},{14,1},{14,9},{14,29},{14,3},{14,13},{21,31},{21,26},{21,19},{21,5},{21,30},{21,20},{21,18},{21,33},{21,1},{21,6},{21,28},{21,29},{21,3},{21,7},{31,24},{31,15},{31,5},{31,20},{31,18},{31,33},{31,1},{31,9},{31,29},{31,7},{31,13},{26,19},{26,15},{26,30},{26,20},{26,11},{26,1},{26,6},{26,9},{26,3},{26,7},{26,13},{19,24},{19,15},{19,5},{19,20},{19,18},{19,33},{19,1},{19,6},{19,9},{19,7},{19,13},{24,15},{24,30},{24,20},{24,33},{24,1},{24,29},{24,3},{24,13},{15,11},{15,1},{15,28},{15,3},{5,30},{5,18},{5,33},{5,11},{5,1},{5,6},{5,28},{5,9},{5,13},{30,18},{30,33},{30,11},{30,6},{30,9},{30,13},{20,1},{20,29},{20,7},{20,13},{18,33},{18,1},{18,28},{18,13},{33,1},{33,6},{33,3},{11,6},{11,28},{11,9},{11,3},{11,7},{1,28},{1,29},{1,7},{6,28},{6,9},{6,29},{6,3},{6,7},{6,13},{28,29},{28,13},{9,7},{9,13},{29,3},{29,7},{3,13},{7,13}}));

    }
}
