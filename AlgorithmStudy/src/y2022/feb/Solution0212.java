package y2022.feb;

import java.util.*;

// https://leetcode.com/problems/word-ladder/
public class Solution0212 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        /*
        begin -> end 변환
        beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
        "hit" -> "hot" -> "dot" -> "dog" -> cog"
        5번

        // a -> b로 가능한것을 그래프 형태로 치환 처리 해놓고
        // bfs 나 dfs를 통해서 최단 거리 탐색으로 찾기

        hot -> dot, lot 으로 변환 가능한데 ..
        이걸 어떻게 찾지? 뭐. 생으로 찾아야지..
         */
        Map<String, Set<Integer>> wordIndexMap = new HashMap<>();
        wordList.add(beginWord);
        int endIdx = -1;
        for (int i = 0; i < wordList.size(); i++) {
            wordIndexMap.put(wordList.get(i), new HashSet<>());
            if (endWord.equals(wordList.get(i))) {
                endIdx = i;
            }
        }
        if (endIdx == -1) {
            return 0;
        }

        for (int i = 0; i < wordList.size(); i++) {
            String word1 = wordList.get(i);
            for (int j = i; j < wordList.size(); j++) {
                int diff = 0;
                String word2 = wordList.get(j);
                for (int k = 0; k < word1.length(); k++) {
                    if (word1.charAt(k) != word2.charAt(k)) {
                        diff ++;
                        if (diff == 2) {
                            break;
                        }
                    }
                }
                if (diff == 1) {
                    wordIndexMap.get(word1).add(j);
                    wordIndexMap.get(word2).add(i);
                }
            }
        }

        System.out.println(wordIndexMap);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[wordList.size()];
        queue.add(wordList.size() - 1);

        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            step ++;
            for (int i = 0; i < size; i++) {
                int idx = queue.poll();
                visited[idx] = true;
                if (idx == endIdx) {
                    return step;
                }

                for (Integer nextIdx : wordIndexMap.get(wordList.get(idx))) {
                    if (!visited[nextIdx]) {
                        queue.add(nextIdx);
                    }
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Solution0212 s = new Solution0212();

        //System.out.println(s.ladderLength("hit", "cog", new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"))));
        //System.out.println(s.ladderLength("hit", "cog", new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log"))));

        Set<String> randomWord = new HashSet<>();
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        while (randomWord.size() != 5001) {
            String generatedString = random.ints(leftLimit, rightLimit + 1)
                    .limit(targetStringLength)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();

            randomWord.add(generatedString);
        }

        for (String s1 : randomWord) {
            System.out.print("\"" + s1 + "\",");
        }


    }
}
